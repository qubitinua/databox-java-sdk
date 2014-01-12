package com.databox.sdk.widgets;

import com.databox.sdk.widgets.MessagesDataProvider;

public class MessagesDataProviderTest extends AbstractDataProviderTest<MessagesDataProvider> {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void addAdditionalData(MessagesDataProvider dataProvider) {
		dataProvider.add("You have **25 new followers.**");
		dataProvider.add("You have **10 new leads.**");
	}

	@Override
	protected MessagesDataProvider newDataProvider() {
		return new MessagesDataProvider("visits");
	}

}
