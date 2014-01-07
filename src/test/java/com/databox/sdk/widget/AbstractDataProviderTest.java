package com.databox.sdk.widget;

import java.util.Date;

import junit.framework.TestCase;

import com.databox.sdk.widgets.AbstractBuilder;
import com.databox.sdk.widgets.AbstractDataProvider;
import com.google.gson.Gson;

public abstract class AbstractDataProviderTest<T extends AbstractDataProvider, B extends AbstractBuilder<T>> extends TestCase {
	protected T _dataProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public final void testDataProvider() {
		/* First create a new Table.Builder */
		B builder = newBuilder();

		/* Date is optional (current date is used by default) */
		builder.setKPIName(getKPIName()).setDate(new Date());

		addAdditionalData(builder);

		_dataProvider = builder.build();

		String json = new Gson().toJson(_dataProvider.getKPIs());
		System.out.println(json);
	}

	protected abstract void addAdditionalData(B builder);

	protected abstract String getKPIName();

	protected abstract B newBuilder();

}
