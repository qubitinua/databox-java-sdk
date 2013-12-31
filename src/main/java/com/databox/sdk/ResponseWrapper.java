package com.databox.sdk;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class ResponseWrapper {
	private boolean _succeeded = false;
	private String _message;

	public boolean isSucceeded() {
		return _succeeded;
	}

	public void setSucceeded(boolean succeeded) {
		_succeeded = succeeded;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}
}
