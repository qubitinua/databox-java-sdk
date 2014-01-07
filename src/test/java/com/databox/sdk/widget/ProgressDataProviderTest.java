package com.databox.sdk.widget;

import com.databox.sdk.widgets.progress.ProgressDataProvider;
import com.databox.sdk.widgets.progress.ProgressDataProvider.Builder;

public class ProgressDataProviderTest extends AbstractBuilderDataProviderTest<ProgressDataProvider, ProgressDataProvider.Builder> {
	protected ProgressDataProvider _dataProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void addAdditionalData(Builder builder) {
		builder.setLabel("Last 7 Days") //
				.setValue(23000d) //
				.setMaxValue(19000d);
	}

	protected String getKPIName() {
		return "revenue";
	}

	@Override
	protected Builder newBuilder() {
		return new Builder();
	}

}