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
	protected boolean normalized;

	protected AbstractDataProvider(String kpiName) {
		this.kpiName = kpiName;
	}

	/**
	 * 
	 * @return The KPI name for this data provider.
	 */
	public String getKpiName() {
		return kpiName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isNormalized() {
		return normalized;
	}

	public void setNormalized(boolean normalized) {
		this.normalized = normalized;
	}
}