package com.databox.sdk.widget;

import java.util.Date;

import com.databox.sdk.widgets.AbstractBuilder;
import com.databox.sdk.widgets.AbstractDataProvider;

public abstract class AbstractBuilderDataProviderTest<T extends AbstractDataProvider, B extends AbstractBuilder<T>> extends AbstractDataProviderTest<T> {
	protected T _dataProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected final T newDataProvider() {
		/* First create a new Table.Builder */
		B builder = newBuilder();

		/* Date is optional (current date is used by default) */
		builder.setKPIName(getKPIName()).setDate(new Date());

		addAdditionalData(builder);

		return builder.build();
	}

	@Override
	protected void addAdditionalData(T dataProvider) {
		/* not needed in case of builder - override if needed */
	}

	protected abstract void addAdditionalData(B builder);

	protected abstract String getKPIName();

	protected abstract B newBuilder();

}
