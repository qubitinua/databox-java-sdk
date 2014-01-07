package com.databox.sdk.widgets.messages;

import java.util.ArrayList;
import java.util.Collection;

import com.databox.sdk.kpi.KPI;
import com.databox.sdk.widgets.AbstractBuilder;
import com.databox.sdk.widgets.AbstractDataProvider;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class ProgressDataProvider extends AbstractDataProvider {
	private String label;
	private Double value;
	private Double maxValue;

	protected ProgressDataProvider() {
	}

	@Override
	public Collection<KPI> getKPIs() {
		ArrayList<KPI> kpis = new ArrayList<KPI>();
		kpis.add(new KPI.Builder().setKey(kpiName + "@label").setValue(label).setDate(date).build());
		kpis.add(new KPI.Builder().setKey(kpiName + "@max").setValue(maxValue).setDate(date).build());
		kpis.add(new KPI.Builder().setKey(kpiName + "@value").setValue(value).setDate(date).build());
		return kpis;
	}

	public static class Builder extends AbstractBuilder<ProgressDataProvider> {
		private String label;
		private Double value;
		private Double maxValue;

		@Override
		protected ProgressDataProvider newDataProvider() {
			return new ProgressDataProvider();
		}

		@Override
		protected void buildImpl(ProgressDataProvider dataProvider) {
			if (label == null || label.trim().isEmpty()) {
				throw new RuntimeException("Label is required field for Progress Widget");
			}
			dataProvider.label = label;

			if (value == null) {
				throw new RuntimeException("Value is required field for Progress Widget");
			}
			dataProvider.value = value;

			if (maxValue == null) {
				throw new RuntimeException("Max value is required field for Progress Widget");
			}
			dataProvider.maxValue = maxValue;
		}

		public Builder setLabel(String label) {
			this.label = label;
			return this;
		}

		public Builder setValue(Double value) {
			this.value = value;
			return this;
		}

		public Builder setMaxValue(Double maxValue) {
			this.maxValue = maxValue;
			return this;
		}
	}
}
