package com.databox.sdk;

import com.databox.sdk.impl.DataPushException;

/**
 * 
 * Interface that serves as a sink for the data retrieved from different providers.
 * 
 * @author Uros Majeric
 * 
 */
public interface DataSink<T extends CustomConnection> {

	/**
	 * Push the data from all connections to the sink.
	 * 
	 * @return The response that was returned from Databox server wrapped in a ResponseWrapper.
	 * 
	 * @throws DataPushException
	 */
	ResponseWrapper push(T connection) throws DataPushException;

	/**
	 * 
	 * Method returns the logs for the latest push for connection.
	 * 
	 * @param connection
	 *            Connection for which we would like to get the log.
	 * @return String for the latest error.
	 * @throws Exception
	 */
	String getLogs(T connection) throws Exception;

}
