package com.databox.sdk.widgets;

import java.util.Date;

import com.databox.sdk.DataProvider;

/**
 * 
 * @author Uros Majeric
 * 
 */
public abstract class AbstractDataProvider implements DataProvider {
	protected final String kpiName;
	protected Date date;

	protected AbstractDataProvider(String kpiName) {
		this.kpiName = kpiName;
	}

	public String getKpiName() {
		return kpiName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}