package com.databox.sdk.widgets;

import com.databox.sdk.widgets.PipelineDataProvider;

public class PipelineDataProviderTest extends AbstractDataProviderTest<PipelineDataProvider> {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void addAdditionalData(PipelineDataProvider dataProvider) {
		/* Define items for the pipeline */
		dataProvider.addItem("Visitors", 56798, 100);
		dataProvider.addItem("Signups", 6342, 11.1659d);
		dataProvider.addItem("Buys", 341);
	}

	@Override
	protected PipelineDataProvider newDataProvider() {
		return new PipelineDataProvider("pipe_visits");
	}

}
