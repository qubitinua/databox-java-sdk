package com.databox.sdk.widgets;

/**
 * 
 * @author Uros Majeric
 * 
 */
class Item {
	private final String label;
	private final Object value;
	private final Object change;

	public Item(String label, Object value) {
		this(label, value, "");
	}

	public Item(String label, Object value, Object change) {
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