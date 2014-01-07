package com.databox.sdk.widgets.table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.databox.sdk.kpi.KPI;
import com.databox.sdk.widgets.AbstractBuilder;
import com.databox.sdk.widgets.AbstractDataProvider;
import com.google.gson.Gson;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class TableDataProvider extends AbstractDataProvider {
	private List<Column> columns = new ArrayList<Column>();
	private List<Row> rows = new ArrayList<Row>();

	private TableDataProvider() {
	}

	public List<Column> getColumns() {
		return columns;
	}

	public List<Row> getRows() {
		return rows;
	}

	@Override
	public Collection<KPI> getKPIs() {
		ArrayList<KPI> kpis = new ArrayList<KPI>();

		/* Add column definitions to the KPIs */
		Gson gson = new Gson();
		String json = gson.toJson(columns);
		KPI columnsKPI = new KPI.Builder().setKey(kpiName + "@columns").setValue(json).setDate(date).build();
		kpis.add(columnsKPI);

		/* Add rows to the KPIs */
		for (int i = 0; i < rows.size(); i++) {
			Row row = rows.get(i);
			List<Object> values = new ArrayList<Object>();
			List<Object> changes = new ArrayList<Object>();
			List<String> valueFormats = new ArrayList<String>();
			List<String> changeFormats = new ArrayList<String>();
			for (Cell cell : row.getCells()) {
				values.add(cell.getValue());
				changes.add(cell.getChange());
				valueFormats.add(cell.getValueFormat());
				changeFormats.add(cell.getChangeFormat());
			}
			kpis.add(new KPI.Builder().setKey(kpiName + "@row_" + i).setValue(gson.toJson(values)).setDate(date).build());
			kpis.add(new KPI.Builder().setKey(kpiName + "@change_" + i).setValue(gson.toJson(changes)).setDate(date).build());
			kpis.add(new KPI.Builder().setKey(kpiName + "@value_format_" + i).setValue(gson.toJson(valueFormats)).setDate(date).build());
			kpis.add(new KPI.Builder().setKey(kpiName + "@change_format_" + i).setValue(gson.toJson(changeFormats)).setDate(date).build());
		}
		return kpis;
	}

	/**
	 * Builder ensures that columns are always added first after that all rows are added. Otherwise user could add column after rows were added.
	 * 
	 * @author Uros Majeric
	 * 
	 */
	public static class Builder extends AbstractBuilder<TableDataProvider> {
		private List<Column> columns = new ArrayList<Column>();
		private List<Row> rows = new ArrayList<Row>();

		public Builder() {
		}

		public Builder addColumn(Column column) {
			columns.add(column);
			return this;
		}

		public Builder addRow(Row row) {
			this.rows.add(row);
			return this;
		}

		@Override
		protected TableDataProvider newDataProvider() {
			return new TableDataProvider();
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
		}

	}
}
