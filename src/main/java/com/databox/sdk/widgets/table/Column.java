package com.databox.sdk.widgets.table;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class Column {
	public enum ColumnType {
		INT, FLOAT, DATE, STRING;

		public String toString() {
			return super.toString().toLowerCase();
		};
	}

	public enum ColumnSort {
		asc, desc;
	}

	private String name;
	private String type; /* This has to be a string for JSON to send the correct data. */
	private ColumnSort sort;

	public Column() {
	}

	public Column(String name) {
		this(name, ColumnType.STRING);
	}

	public Column(String name, ColumnType type) {
		this(name, type, null);
	}

	public Column(String name, ColumnType type, ColumnSort sort) {
		this.name = name;
		if (type != null) {
			this.type = type.toString();
		}
		this.sort = sort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ColumnType getType() {
		if (type == null) {
			return null;
		}
		return ColumnType.valueOf(type);
	}

	public void setType(ColumnType type) {
		if (type != null) {
			this.type = type.toString();
		} else {
			this.type = null;
		}
	}

	public ColumnSort getSort() {
		return sort;
	}

	public void setSort(ColumnSort sort) {
		this.sort = sort;
	}
}
