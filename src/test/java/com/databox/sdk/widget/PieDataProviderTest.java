package com.databox.sdk.widget;

import com.databox.sdk.widgets.pie.PieDataProvider;

public class PieDataProviderTest extends AbstractDataProviderTest<PieDataProvider> {

	@Override
	protected void addAdditionalData(PieDataProvider dataProvider) {
		/* Define slices for the pipeline */
		dataProvider.addSlice("Jakob", 1419911, 4);
		dataProvider.addSlice("Uroš", 1112111, -7);
		dataProvider.addSlice("Jan", 615234);
	}

	@Override
	protected PieDataProvider newDataProvider() {
		return new PieDataProvider("top_three_users");
	}

}
