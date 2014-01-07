package com.databox.sdk.widget;

import com.databox.sdk.widgets.messages.ProgressDataProvider;

public class ProgressDataProviderTest extends AbstractDataProviderTest<ProgressDataProvider, ProgressDataProvider.Builder> {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void addAdditionalData(ProgressDataProvider.Builder builder) {
		builder.setLabel("Last 7 Days") //
				.setValue(23000d) //
				.setMaxValue(19000d);
	}

	@Override
	protected String getKPIName() {
		return "revenue";
	}

	@Override
	protected ProgressDataProvider.Builder newBuilder() {
		return new ProgressDataProvider.Builder();
	}

}
