package com.databox.sdk.widget;

import com.databox.sdk.widgets.funnel.PieDataProvider;

public class PieDataProviderTest extends AbstractDataProviderTest<PieDataProvider, PieDataProvider.Builder> {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void addAdditionalData(PieDataProvider.Builder builder) {
		/* Define slices for the pipeline */
		builder.addSlice("Jakob", 1419911, 4);
		builder.addSlice("Uroš", 1112111, -7);
		builder.addSlice("Jan", 615234);
	}

	@Override
	protected String getKPIName() {
		return "top_three_users";
	}

	@Override
	protected PieDataProvider.Builder newBuilder() {
		return new PieDataProvider.Builder();
	}

}
