package com.databox.sdk.widget;

import com.databox.sdk.widgets.progress.ProgressDataProvider;
import com.databox.sdk.widgets.table.Cell;
import com.databox.sdk.widgets.table.Column;
import com.databox.sdk.widgets.table.Column.ColumnSort;
import com.databox.sdk.widgets.table.Column.ColumnType;
import com.databox.sdk.widgets.table.Row;
import com.databox.sdk.widgets.table.TableDataProvider;

public class TableDataProviderTest extends AbstractBuilderDataProviderTest<TableDataProvider, TableDataProvider.Builder> {
	protected ProgressDataProvider _dataProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void addAdditionalData(TableDataProvider.Builder builder) {
		/* Define columns for the table */
		builder.addColumn(new Column("Visitors", ColumnType.STRING, ColumnSort.asc));
		builder.addColumn(new Column("Today", ColumnType.STRING));

		/* Add rows to the table */
		Row row = new Row.Builder().addCell(new Cell("Returning")).addCell(new Cell(44937)).build();
		builder.addRow(row);
		row = new Row.Builder().addCell(new Cell("New ($)")).addCell(new Cell(2380.84)).build();
		builder.addRow(row);
		row = new Row.Builder().addCell(new Cell("Returning ($)")).addCell(new Cell(144339.23)).build();
		builder.addRow(row);
	}

	protected String getKPIName() {
		return "new_vs_returning";
	}

	@Override
	protected TableDataProvider.Builder newBuilder() {
		return new TableDataProvider.Builder();
	}

	public void testTableDataProviderWrongNumberOfColumns() {
		TableDataProvider.Builder builder = new TableDataProvider.Builder();
		builder.setKPIName("new_vs_returning"); //
		builder.addColumn(new Column("Visitors", ColumnType.STRING, ColumnSort.asc));

		builder.addRow(new Row.Builder().addCell(new Cell("Returning")).addCell(new Cell(44937)).build());
		try {
			builder.build();
			assertTrue("Exception should be thrown! Wrong number of items in row.", false);
		} catch (RuntimeException e) {
			/* Expected exception */
		}
	}

}