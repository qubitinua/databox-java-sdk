package com.databox.sdk.impl;

import com.databox.sdk.DefaultCustomConnection;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class DataboxCustomConnection extends DefaultCustomConnection {
	private final String _apiKey;
	private final String _uniqueURL;

	/**
	 * 
	 * @param apiKey
	 *            API Key ('Push token' - as seen on custom connection screen in WEB App) for Databox connection (has to be provided).
	 * @param uniqueURL
	 *            Unique URL ('Push URL' - as seen on custom connection screen in WEB App) for Databox connection (has to be provided).<br />
	 *            You need to provide only the ending characters after last slash ('/') in Push URL. e.g. if push URL you see on the WEB App is
	 *            http://zep.com:8080/push/custom/40n9pp9ue0mcskw0 then you need to provide only the string '40n9pp9ue0mcskw0'.
	 */
	public DataboxCustomConnection(String apiKey, String uniqueURL) {
		_apiKey = apiKey;
		_uniqueURL = uniqueURL;
	}

	/**
	 * 
	 * @return API Key ('Push token') for Databox conection.
	 */
	public String getApiKey() {
		return _apiKey;
	}

	/**
	 * 
	 * @return Unique URL ('Push URL') for Databox connection.
	 */
	public String getUniqueURL() {
		return _uniqueURL;
	}

}
