package com.databox.sdk.widget;

import com.databox.sdk.widgets.pipeline.PipelineDataProvider;

public class PipelineDataProviderTest extends AbstractDataProviderTest<PipelineDataProvider, PipelineDataProvider.Builder> {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void addAdditionalData(PipelineDataProvider.Builder builder) {
		/* Define slices for the pipeline */
		builder.addSlice("Visitors", 56798, 100);
		builder.addSlice("Signups", 6342, 11.1659d);
		builder.addSlice("Buys", 341);
	}

	@Override
	protected String getKPIName() {
		return "visits";
	}

	@Override
	protected PipelineDataProvider.Builder newBuilder() {
		return new PipelineDataProvider.Builder();
	}

}
