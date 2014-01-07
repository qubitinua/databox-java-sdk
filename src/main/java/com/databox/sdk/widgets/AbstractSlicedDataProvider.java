package com.databox.sdk.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.databox.sdk.kpi.KPI;
import com.google.gson.Gson;

/**
 * 
 * @author Uros Majeric
 * 
 */
public abstract class AbstractSlicedDataProvider extends AbstractDataProvider {
	protected List<Slice> slices = new ArrayList<Slice>();

	protected AbstractSlicedDataProvider(String kpiName) {
		super(kpiName);
	}

	@Override
	public Collection<KPI> getKPIs() {
		ArrayList<KPI> kpis = new ArrayList<KPI>();

		Gson gson = new Gson();

		List<String> labels = new ArrayList<String>();
		for (int i = 0; i < slices.size(); i++) {
			Slice slice = slices.get(i);
			if (slice != null) {
				labels.add(slice.getLabel());
				kpis.add(new KPI.Builder().setKey(kpiName + "@row_" + i).setValue(gson.toJson(slice.getValue())).setDate(date).build());
				kpis.add(new KPI.Builder().setKey(kpiName + "@change_" + i).setValue(gson.toJson(slice.getChange())).setDate(date).build());
			}
		}

		KPI labelsKPI = new KPI.Builder().setKey(kpiName + "@labels").setValue(gson.toJson(labels)).setDate(date).build();
		kpis.add(labelsKPI);
		return kpis;
	}

	public void addSlice(String label, Object value) {
		addSlice(label, value, null);
	}

	public void addSlice(String label, Object value, Object change) {
		if (change == null) {
			change = "";
		}
		slices.add(new Slice(label, value, change));
	}

}
