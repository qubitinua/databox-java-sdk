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

	public DataboxCustomConnection(String apiKey, String uniqueURL) {
		_apiKey = apiKey;
		_uniqueURL = uniqueURL;
	}

	public String getApiKey() {
		return _apiKey;
	}

	public String getUniqueURL() {
		return _uniqueURL;
	}

}
