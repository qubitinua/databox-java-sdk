package com.databox.sdk;

import java.util.List;

/**
 * 
 * @author Uros Majeric
 * 
 */
public interface CustomConnection {

	/**
	 * 
	 * @return list of DataProviders for this connection.
	 */
	List<DataProvider> getDataProviders();
}
