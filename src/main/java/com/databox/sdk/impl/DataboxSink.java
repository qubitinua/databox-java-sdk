package com.databox.sdk.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.databox.Environment;
import com.databox.sdk.DataProvider;
import com.databox.sdk.DataSink;
import com.databox.sdk.ResponseWrapper;
import com.databox.sdk.kpi.KPI;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Default implementation for DataSink. DataboxSink is a sink for the KPIs generated for custom connection created on Databox WEB app.
 * 
 * @author Uros Majeric
 * 
 */
public class DataboxSink implements DataSink<DataboxCustomConnection> {
	private static final String PUSH_URL_PATH = "/push/custom";
	private static final Logger logger = LoggerFactory.getLogger(DataboxSink.class);

	/**
	 * 
	 */
	public DataboxSink() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public ResponseWrapper push(DataboxCustomConnection connection) throws DataPushException {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		DataboxRequestModel aggregated = new DataboxRequestModel();
		for (DataProvider dp : connection.getDataProviders()) {
			aggregated.addKPIs(dp.getKPIs());
		}

		Gson gson = new Gson();
		String json = gson.toJson(aggregated);

		try {
			String databoxBaseURL = Environment.getDataboxBaseURL();
			String uniqueURL = connection.getUniqueURL();
			/* if user has entered whole Push URL by mistake then eliminate the leading URL and extract only the App ID */
			if (uniqueURL.toLowerCase().contains(PUSH_URL_PATH)) {
				int beginIndex = uniqueURL.toLowerCase().indexOf(PUSH_URL_PATH) + PUSH_URL_PATH.length() + 1;
				uniqueURL = uniqueURL.substring(beginIndex, uniqueURL.length());
			}
			URI url = URI.create(databoxBaseURL + PUSH_URL_PATH + "/" + uniqueURL);

			DataboxHttpClient client = new DataboxHttpClient(url, connection.getApiKey());
			String response = client.postData(json);
			logger.debug("Response from Databox server was: {}", response);
			if (response != null) {
				parseResponse(response, responseWrapper);
			} else {
				responseWrapper.setSucceeded(false);
				if (client.getLastStatus() != null) {
					responseWrapper.setMessage(client.getLastStatus());
				} else {
					responseWrapper.setMessage("Response was empty and there is no last status message!");
				}
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			throw new DataPushException(e);
		}
		return responseWrapper;
	}

	private boolean parseResponse(String response, ResponseWrapper responseWrapper) {
		JsonParser parser = new JsonParser();
		JsonElement parsed = parser.parse(response);
		if (parsed != null && parsed.isJsonObject()) {
			JsonElement jsonResponse = parsed.getAsJsonObject().get("response");
			if (jsonResponse != null && jsonResponse.isJsonObject()) {
				JsonObject next = jsonResponse.getAsJsonObject();
				if (next != null) {
					if (next.get("type") != null && !next.get("type").isJsonNull()) {
						boolean succeeded = "success".equalsIgnoreCase(next.get("type").getAsString());
						responseWrapper.setSucceeded(succeeded);
					}
					if (next.get("message") != null && !next.get("message").isJsonNull()) {
						responseWrapper.setMessage(next.get("message").getAsString());
					}
				} else {
					responseWrapper.setSucceeded(false);
					responseWrapper.setMessage("Wron response format.");
				}
			}
		}
		return false;
	}

	private static final class DataboxRequestModel {
		protected List<KPI> data = new ArrayList<KPI>();

		public void addKPIs(Collection<KPI> kpis) {
			data.addAll(kpis);
		}
	}
}
