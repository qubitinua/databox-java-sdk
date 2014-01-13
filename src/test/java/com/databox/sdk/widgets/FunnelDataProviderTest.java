package com.databox.sdk.widgets;

import com.databox.sdk.widgets.FunnelDataProvider;

public class FunnelDataProviderTest extends AbstractDataProviderTest<FunnelDataProvider> {

	@Override
	protected void addAdditionalData(FunnelDataProvider dataProvider) {
		dataProvider.addItem("Visitors", 56798, 100);
		dataProvider.addItem("Signups", 6342, 11.1659d);
		dataProvider.addItem("Buys", 341);
	}

	@Override
	protected FunnelDataProvider newDataProvider() {
		return new FunnelDataProvider("funnel");
	}

}
