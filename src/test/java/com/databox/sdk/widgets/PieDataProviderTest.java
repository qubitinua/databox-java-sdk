package com.databox.sdk.widgets;

import com.databox.sdk.widgets.PieDataProvider;

public class PieDataProviderTest extends AbstractDataProviderTest<PieDataProvider> {

	@Override
	protected void addAdditionalData(PieDataProvider dataProvider) {
		/* Define items for the pipeline */
		dataProvider.addItem("Jakob", 1419911, 4);
		dataProvider.addItem("Uroš", 1112111, -7);
		dataProvider.addItem("Jan", 615234);
	}

	@Override
	protected PieDataProvider newDataProvider() {
		return new PieDataProvider("top_three_users");
	}

}
