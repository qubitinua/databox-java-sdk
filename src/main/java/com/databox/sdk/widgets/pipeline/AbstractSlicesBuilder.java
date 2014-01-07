package com.databox.sdk.widgets.pipeline;

import java.util.ArrayList;
import java.util.List;

import com.databox.sdk.widgets.AbstractBuilder;
import com.databox.sdk.widgets.AbstractDataProvider;
import com.databox.sdk.widgets.pipeline.PipelineDataProvider.Slice;

public abstract class AbstractSlicesBuilder<T extends AbstractDataProvider> extends AbstractBuilder<T> {
	protected List<Slice> slices = new ArrayList<Slice>();

	public void addSlice(String label, Object value) {
		addSlice(label, value, null);
	}

	public void addSlice(String label, Object value, Object change) {
		if (change == null) {
			change = "";
		}
		slices.add(new Slice(label, value, change));
	}
}