package com.databox.sdk.widgets.table;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class Row {
	private List<Cell> cells = new ArrayList<Cell>();

	private Row() {
	}

	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

	@Override
	public String toString() {
		return Row.class.getSimpleName() + "(" + cells + ")";
	}

	public static class Builder {
		private List<Cell> cells = new ArrayList<Cell>();

		public Builder() {
		}

		public Builder addCell(Cell cell) {
			this.cells.add(cell);
			return this;
		}

		public Row build() {
			Row row = new Row();
			row.cells.addAll(this.cells);
			return row;
		}
	}

}
