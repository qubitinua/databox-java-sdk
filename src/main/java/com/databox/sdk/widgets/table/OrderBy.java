package com.databox.sdk.widgets.table;

/**
 * Class serves for creating a sort order for specific column.
 * 
 * @author Uros Majeric
 * 
 */
public class OrderBy {
	private String column;
	private ColumnSort sort;

	/**
	 * Sort direction for the column.
	 * 
	 */
	public enum ColumnSort {
		asc, desc;
	}

	/**
	 * 
	 * @param column
	 *            Column name for which we will apply the sort.
	 * @param sort
	 *            Sort direction for column provided in first argument.
	 */
	public OrderBy(String column, ColumnSort sort) {
		this.column = column;
		this.sort = sort;
	}

	public String getColumn() {
		return column;
	}

	public ColumnSort getSort() {
		return sort;
	}
}
