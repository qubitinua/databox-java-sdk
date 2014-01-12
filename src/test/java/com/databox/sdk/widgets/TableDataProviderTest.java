package com.databox.sdk.widgets;

import com.databox.sdk.widgets.ProgressDataProvider;
import com.databox.sdk.widgets.TableDataProvider;
import com.databox.sdk.widgets.table.Cell;
import com.databox.sdk.widgets.table.OrderBy.ColumnSort;
import com.databox.sdk.widgets.table.Row;

public class TableDataProviderTest extends AbstractBuilderDataProviderTest<TableDataProvider, TableDataProvider.Builder> {
	protected ProgressDataProvider _dataProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void addAdditionalData(TableDataProvider.Builder builder) {
		/* Define columns for the table */
		builder.addColumn("Visitors");
		builder.addColumn("Today");

		builder.addOrderBy("Visitors", ColumnSort.asc);

		/* Add rows to the table */
		Row row = new Row.Builder().addCell(new Cell("Returning")).addCell(new Cell(44937, 12, "%d")).build();
		builder.addRow(row);
		row = new Row.Builder().addCell(new Cell("New ($)")).addCell(new Cell(2380.84)).build();
		builder.addRow(row);
		row = new Row.Builder().addCell(new Cell("Returning ($)")).addCell(new Cell(144339.23)).build();
		builder.addRow(row);
	}

	@Override
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
		builder.addColumn("Visitors");

		builder.addRow(new Row.Builder().addCell(new Cell("Returning")).addCell(new Cell(44937)).build());
		try {
			builder.build();
			assertTrue("Exception should be thrown! Wrong number of items in row.", false);
		} catch (RuntimeException e) {
			/* Expected exception */
		}
	}

}