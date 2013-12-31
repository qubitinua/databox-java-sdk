package com.databox.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.databox.sdk.kpi.KPI;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class DefaultDataProvider implements DataProvider {
	protected List<KPI> data = new ArrayList<KPI>();

	@Override
	public Collection<KPI> getKPIs() {
		return data;
	}

	public void addKPI(KPI kpi) {
		data.add(kpi);
	}

	public void addKPIs(List<KPI> kpis) {
		data.addAll(kpis);
	}
}
