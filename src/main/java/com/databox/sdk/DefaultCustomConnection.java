package com.databox.sdk;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class DefaultCustomConnection implements CustomConnection {
	private List<DataProvider> _dataProviders = new ArrayList<DataProvider>();

	@Override
	public List<DataProvider> getDataProviders() {
		return _dataProviders;
	}

	public void addDataProvider(DataProvider dataProvider) {
		_dataProviders.add(dataProvider);
	}
}
