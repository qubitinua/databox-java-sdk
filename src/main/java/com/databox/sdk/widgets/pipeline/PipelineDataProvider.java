package com.databox.sdk.widgets.pipeline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.databox.sdk.kpi.KPI;
import com.databox.sdk.widgets.AbstractDataProvider;
import com.google.gson.Gson;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class PipelineDataProvider extends AbstractDataProvider {
	protected List<Slice> slices = new ArrayList<Slice>();

	protected PipelineDataProvider() {
	}

	@Override
	public Collection<KPI> getKPIs() {
		ArrayList<KPI> kpis = new ArrayList<KPI>();

		Gson gson = new Gson();

		List<String> labels = new ArrayList<String>();
		for (int i = 0; i < slices.size(); i++) {
			Slice slice = slices.get(i);
			if (slice != null) {
				labels.add(slice.label);
				kpis.add(new KPI.Builder().setKey(kpiName + "@row_" + i).setValue(gson.toJson(slice.value)).setDate(date).build());
				kpis.add(new KPI.Builder().setKey(kpiName + "@change_" + i).setValue(gson.toJson(slice.change)).setDate(date).build());
			}
		}

		KPI labelsKPI = new KPI.Builder().setKey(kpiName + "@labels").setValue(gson.toJson(labels)).setDate(date).build();
		kpis.add(labelsKPI);
		return kpis;
	}

	public static class Builder extends AbstractSlicesBuilder<PipelineDataProvider> {
		@Override
		protected PipelineDataProvider newDataProvider() {
			return new PipelineDataProvider();
		}
		
		@Override
		protected void buildImpl(PipelineDataProvider dataProvider) {
			dataProvider.slices.addAll(slices);
		}
	}

	static class Slice {
		private final String label;
		private final Object value;
		private final Object change;

		public Slice(String label, Object value, Object change) {
			this.label = label;
			this.value = value;
			this.change = change;
		}
	}

}
