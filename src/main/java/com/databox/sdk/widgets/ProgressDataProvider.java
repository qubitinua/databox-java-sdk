package com.databox.sdk.widgets;

import java.util.ArrayList;
import java.util.Collection;

import com.databox.sdk.kpi.KPI;

/**
 * Use ProgressDataProvider.Builder to create a new instance of ProgressDataProvider. Builder ensures that all needed data is entered before creating a new
 * instance of ProgressDataProvider.
 * 
 * @author Uros Majeric
 * 
 */
public class ProgressDataProvider extends AbstractDataProvider {
	private String label;
	private Double value;
	private Double maxValue;

	/**
	 * 
	 * @param kpiName
	 *            used when the custom connection was created on WEB app page.
	 */
	private ProgressDataProvider(String kpiName) {
		super(kpiName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Collection<KPI> getKPIs() {
		ArrayList<KPI> kpis = new ArrayList<KPI>();
		kpis.add(new KPI.Builder().setKey(kpiName + "@label").setValue(label).setDate(date).setNormalized(normalized).build());
		kpis.add(new KPI.Builder().setKey(kpiName + "").setValue(value).setDate(date).setNormalized(normalized).build());
		kpis.add(new KPI.Builder().setKey(kpiName + "@max_value").setValue(maxValue).setDate(date).setNormalized(normalized).build());
		return kpis;
	}

	public static class Builder extends AbstractBuilder<ProgressDataProvider> {
		private String label;
		private Double value;
		private Double maxValue;

		@Override
		protected ProgressDataProvider newDataProvider() {
			return new ProgressDataProvider(kpiName);
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
