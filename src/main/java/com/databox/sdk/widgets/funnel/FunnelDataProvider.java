package com.databox.sdk.widgets.funnel;

import com.databox.sdk.widgets.pipeline.AbstractSlicesBuilder;
import com.databox.sdk.widgets.pipeline.PipelineDataProvider;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class FunnelDataProvider extends PipelineDataProvider {
	private FunnelDataProvider() {
	}

	public static class Builder extends AbstractSlicesBuilder<FunnelDataProvider> {
		@Override
		protected FunnelDataProvider newDataProvider() {
			return new FunnelDataProvider();
		}

		@Override
		protected void buildImpl(FunnelDataProvider dataProvider) {
			dataProvider.slices.addAll(slices);
		}
	}

}
