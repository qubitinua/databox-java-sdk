package com.databox.sdk.widgets;

import java.util.Date;

import com.databox.sdk.DataProvider;

/**
 * 
 * @author Uros Majeric
 * 
 */
public abstract class AbstractDataProvider implements DataProvider {
	protected String kpiName;
	protected Date date;

	protected AbstractDataProvider() {
	}

	public String getKpiName() {
		return kpiName;
	}

	void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}

	public Date getDate() {
		return date;
	}

	void setDate(Date date) {
		this.date = date;
	}
}