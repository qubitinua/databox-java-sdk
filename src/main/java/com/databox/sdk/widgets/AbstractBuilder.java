package com.databox.sdk.widgets;

import java.util.Date;

/**
 * 
 * @author Uros Majeric
 * 
 */
public abstract class AbstractBuilder<T extends AbstractDataProvider> {
	protected String kpiName;
	protected Date date;

	public final T build() {
		if (kpiName == null || kpiName.isEmpty()) {
			throw new RuntimeException("KPI name should not be empty!");
		}
		T dataProvider = newDataProvider();
		dataProvider.setDate(date);

		buildImpl(dataProvider);

		return dataProvider;
	}

	public AbstractBuilder<T> setKPIName(String kpiName) {
		this.kpiName = kpiName;
		return this;
	}

	public AbstractBuilder<T> setDate(Date date) {
		this.date = date;
		return this;
	}

	protected abstract void buildImpl(T dataProvider);

	protected abstract T newDataProvider();
}
