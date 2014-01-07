package com.databox.sdk.widget;

import com.databox.sdk.widgets.funnel.FunnelDataProvider;

public class FunnelDataProviderTest extends AbstractDataProviderTest<FunnelDataProvider> {

	@Override
	protected void addAdditionalData(FunnelDataProvider dataProvider) {
		dataProvider.addSlice("Visitors", 56798, 100);
		dataProvider.addSlice("Signups", 6342, 11.1659d);
		dataProvider.addSlice("Buys", 341);
	}

	@Override
	protected FunnelDataProvider newDataProvider() {
		return new FunnelDataProvider("visits");
	}

}
