package com.databox.sdk.widgets.table;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class Cell {
	private Object value;
	private Object change;
//	private String valueFormat;
//	private String changeFormat;

	public Cell() {
	}

	public Cell(Object value) {
		this(value, "");
	}

	public Cell(Object value, Object change) {
		this(value, change, "");
	}

	public Cell(Object value, Object change, String valueFormat) {
		this(value, change, valueFormat, "");
	}

	public Cell(Object value, Object change, String valueFormat, String changeFormat) {
		this.value = value;
		this.change = change;
//		this.valueFormat = valueFormat;
//		this.changeFormat = changeFormat;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

//	public String getValueFormat() {
//		return valueFormat;
//	}
//
//	public void setValueFormat(String valueFormat) {
//		this.valueFormat = valueFormat;
//	}

	public Object getChange() {
		return change;
	}

	public void setChange(Object change) {
		this.change = change;
	}

//	public String getChangeFormat() {
//		return changeFormat;
//	}
//
//	public void setChangeFormat(String changeFormat) {
//		this.changeFormat = changeFormat;
//	}

	@Override
	public String toString() {
		return Cell.class.getSimpleName() + "(" + value + ")";
	}
}
