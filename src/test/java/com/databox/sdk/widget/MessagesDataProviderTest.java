package com.databox.sdk.widget;

import com.databox.sdk.widgets.progress.MessagesDataProvider;

public class MessagesDataProviderTest extends AbstractDataProviderTest<MessagesDataProvider, MessagesDataProvider.Builder> {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void addAdditionalData(MessagesDataProvider.Builder builder) {
		builder.add("You have **25 new followers.**");
		builder.add("You have **10 new leads.**");
	}

	@Override
	protected String getKPIName() {
		return "visits";
	}

	@Override
	protected MessagesDataProvider.Builder newBuilder() {
		return new MessagesDataProvider.Builder();
	}

}
