package com.databox.sdk.widgets;

import com.databox.sdk.widgets.ProgressDataProvider;
import com.databox.sdk.widgets.ProgressDataProvider.Builder;

public class ProgressDataProviderTest extends AbstractBuilderDataProviderTest<ProgressDataProvider, ProgressDataProvider.Builder> {
	protected ProgressDataProvider _dataProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void addAdditionalData(Builder builder) {
		builder.setLabel("Last 7 Days") //
				.setValue(23000d) //
				.setMaxValue(19000d);
	}

	@Override
	protected String getKPIName() {
		return "revenue";
	}

	@Override
	protected Builder newBuilder() {
		return new Builder();
	}

}