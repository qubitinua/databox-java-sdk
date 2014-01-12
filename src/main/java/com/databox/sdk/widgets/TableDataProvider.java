package com.databox.sdk.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.databox.sdk.kpi.KPI;
import com.databox.sdk.widgets.table.Cell;
import com.databox.sdk.widgets.table.OrderBy;
import com.databox.sdk.widgets.table.OrderBy.ColumnSort;
import com.databox.sdk.widgets.table.Row;
import com.google.gson.Gson;

/**
 * TableDataProvider can be build only with the TableDataProvider.Builder. Builder ensures that columns are always added first, after that all rows are added.
 * Otherwise columns could be added after rows were added.
 * 
 * @author Uros Majeric
 * 
 */
public class TableDataProvider extends AbstractDataProvider {
	private List<String> columns = new ArrayList<String>();
	private List<Row> rows = new ArrayList<Row>();
	private List<String> orderByColumns = new ArrayList<String>();

	/**
	 * 
	 * @param kpiName
	 *            used when the custom connection was created on WEB app page.
	 */
	private TableDataProvider(String kpiName) {
		super(kpiName);
	}

	public List<String> getColumns() {
		return columns;
	}

	public List<Row> getRows() {
		return rows;
	}

	public List<String> getOrderByColumns() {
		return orderByColumns;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Collection<KPI> getKPIs() {
		ArrayList<KPI> kpis = new ArrayList<KPI>();

		List<List<Object>> rowValues = new ArrayList<List<Object>>();
		List<List<Object>> changes = new ArrayList<List<Object>>();
		List<List<String>> valueFormats = new ArrayList<List<String>>();
		// List<List<String>> changeFormats = new ArrayList<List<String>>();

		/* Add rows to the KPIs */
		for (int i = 0; i < rows.size(); i++) {
			Row row = rows.get(i);
			// List<String> changeFormats = new ArrayList<String>();
			List<Object> values = new ArrayList<Object>();
			List<Object> ch = new ArrayList<Object>();
			List<String> fmts = new ArrayList<String>();
			// List<String> chFmts = new ArrayList<String>();
			for (Cell cell : row.getCells()) {
				values.add(cell.getValue());
				ch.add(cell.getChange());
				fmts.add(cell.getValueFormat());
				// changeFormats.add(cell.getChangeFormat());
			}
			rowValues.add(values);
			changes.add(ch);
			valueFormats.add(fmts);
			// changeFormats.add(chFmts);
		}

		Gson gson = new Gson();
		kpis.add(new KPI.Builder().setKey(kpiName + "@columns").setValue(gson.toJson(columns)).setDate(date).build());
		kpis.add(new KPI.Builder().setKey(kpiName + "@rows").setValue(gson.toJson(rowValues)).setDate(date).build());
		kpis.add(new KPI.Builder().setKey(kpiName + "@changes").setValue(gson.toJson(changes)).setDate(date).build());
		kpis.add(new KPI.Builder().setKey(kpiName + "@formats").setValue(gson.toJson(valueFormats)).setDate(date).build());
		// kpis.add(new KPI.Builder().setKey(kpiName + "@change_format_" + i).setValue(gson.toJson(changeFormats)).setDate(date).build());
		kpis.add(new KPI.Builder().setKey(kpiName + "@order_by").setValue(gson.toJson(orderByColumns)).setDate(date).build());

		return kpis;
	}

	/**
	 * 
	 * 
	 * @author Uros Majeric
	 * 
	 */
	public static class Builder extends AbstractBuilder<TableDataProvider> {
		private List<String> columns = new ArrayList<String>();
		private List<Row> rows = new ArrayList<Row>();
		private List<OrderBy> orderByColumns = new ArrayList<OrderBy>();

		public Builder() {
		}

		public Builder addColumn(String column) {
			columns.add(column);
			return this;
		}

		public Builder addRow(Row row) {
			this.rows.add(row);
			return this;
		}

		public Builder addOrderBy(String column, ColumnSort sort) {
			this.orderByColumns.add(new OrderBy(column, sort));
			return this;
		}

		@Override
		protected TableDataProvider newDataProvider() {
			return new TableDataProvider(kpiName);
		}

		@Override
		protected void buildImpl(TableDataProvider dataProvider) {
			dataProvider.columns.addAll(this.columns);

			int noOfColumns = this.columns.size();
			for (Row row : this.rows) {
				if (row == null || row.getCells() == null) {
					continue;
				}
				/* if row doesn't have the exact number of items then fail */
				if (noOfColumns != row.getCells().size()) {
					throw new RuntimeException("Wrong number of items in row " + row + ", expected number of items: " + noOfColumns);
				}
				/* if all ok, then add row to the table */
				dataProvider.rows.add(row);
			}

			/* generate orderBy columns for each OrderBy element in list */
			for (OrderBy orderBy : orderByColumns) {
				if (orderBy.getSort() != null && orderBy.getColumn() != null) {
					/* find the index of column in definition */
					int index = this.columns.indexOf(orderBy.getColumn());
					if (index > -1) {
						dataProvider.orderByColumns.add(orderBy.getSort().name() + "#" + index);
					} else {
						throw new RuntimeException("Couldn't find index of column '" + orderBy.getColumn() + "' in columns " + this.columns);
					}
				}
			}
		}

	}
}
