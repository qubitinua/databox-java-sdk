package com.databox.sdk.widgets;

import java.util.Date;

import junit.framework.TestCase;

import com.databox.sdk.ResponseWrapper;
import com.databox.sdk.impl.DataPushException;
import com.databox.sdk.impl.DataboxCustomConnection;
import com.databox.sdk.impl.DataboxSink;
import com.google.gson.Gson;

public abstract class AbstractDataProviderTest<T extends AbstractDataProvider> extends TestCase {
	protected T _dataProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public final void testDataProvider() {
		/* Date is optional (current date is used by default) */
		_dataProvider = newDataProvider();
		_dataProvider.setDate(new Date());
		_dataProvider.setNormalized(true);

		addAdditionalData(_dataProvider);

		String kpis = new Gson().toJson(_dataProvider.getKPIs());

		DataboxSink sink;
		DataboxCustomConnection connection;

		String apiKey = System.getProperty("databox-api-key");
		String sourceToken = System.getProperty("databox-app-id");
		if (apiKey != null && !apiKey.isEmpty() && sourceToken != null && !sourceToken.isEmpty()) {
			sink = new DataboxSink(apiKey);
			connection = new DataboxCustomConnection(sourceToken);
		} else {
			System.err.println("Please provide API Key and APP ID to send data to Databox.");
			return;
		}

		System.out.println(kpis);

		connection.addDataProvider(_dataProvider);

		try {
			ResponseWrapper response = sink.push(connection);
			if (!response.isSucceeded()) {
				System.err.println(response.getMessage());
			} else {
				System.out.println("Data sent!");
			}
		} catch (DataPushException e) {
			e.printStackTrace();
		}
	}

	protected abstract T newDataProvider();

	protected abstract void addAdditionalData(T dataProvider);

}
