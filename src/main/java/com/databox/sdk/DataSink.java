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
	 * @return true if succeeded, false otherwise.
	 * 
	 * @throws DataPushException
	 */
	ResponseWrapper push(T connection) throws DataPushException;

}
