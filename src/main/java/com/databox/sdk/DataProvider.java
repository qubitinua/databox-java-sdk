package com.databox.sdk;

import java.util.Collection;

import com.databox.sdk.kpi.KPI;

/**
 * 
 * This class serves as a KPI provider.
 * 
 * @author Uros Majeric
 * 
 */
public interface DataProvider {
	public Collection<KPI> getKPIs();
}
