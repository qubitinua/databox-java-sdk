package com.databox.sdk.widgets;

/**
 * 
 * @author Uros Majeric
 * 
 */
class Slice {
	private final String label;
	private final Object value;
	private final Object change;

	public Slice(String label, Object value) {
		this(label, value, "");
	}

	public Slice(String label, Object value, Object change) {
		this.label = label;
		this.value = value;
		this.change = change;
	}

	public String getLabel() {
		return label;
	}

	public Object getValue() {
		return value;
	}

	public Object getChange() {
		return change;
	}
}