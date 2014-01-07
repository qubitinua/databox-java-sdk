package com.databox.sdk.widgets.funnel;

import com.databox.sdk.widgets.pipeline.AbstractSlicesBuilder;
import com.databox.sdk.widgets.pipeline.PipelineDataProvider;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class PieDataProvider extends PipelineDataProvider {
	private PieDataProvider() {
	}

	public static class Builder extends AbstractSlicesBuilder<PieDataProvider> {
		@Override
		protected PieDataProvider newDataProvider() {
			return new PieDataProvider();
		}

		@Override
		protected void buildImpl(PieDataProvider dataProvider) {
			dataProvider.slices.addAll(slices);
		}
	}

}
