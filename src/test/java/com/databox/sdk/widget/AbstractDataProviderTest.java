package com.databox.sdk.widget;

import java.util.Date;

import junit.framework.TestCase;

import com.databox.sdk.widgets.AbstractDataProvider;
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

		addAdditionalData(_dataProvider);

		String json = new Gson().toJson(_dataProvider.getKPIs());
		System.out.println(json);
	}

	protected abstract T newDataProvider();

	protected abstract void addAdditionalData(T dataProvider);

}
