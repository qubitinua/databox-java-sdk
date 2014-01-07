package com.databox.sdk.widget;

import com.databox.sdk.widgets.pipeline.PipelineDataProvider;

public class PipelineDataProviderTest extends AbstractDataProviderTest<PipelineDataProvider> {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void addAdditionalData(PipelineDataProvider dataProvider) {
		/* Define slices for the pipeline */
		dataProvider.addSlice("Visitors", 56798, 100);
		dataProvider.addSlice("Signups", 6342, 11.1659d);
		dataProvider.addSlice("Buys", 341);
	}

	@Override
	protected PipelineDataProvider newDataProvider() {
		return new PipelineDataProvider("visits");
	}

}
