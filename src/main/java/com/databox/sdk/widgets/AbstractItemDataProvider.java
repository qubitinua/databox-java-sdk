package com.databox.sdk.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.databox.sdk.kpi.KPI;
import com.google.gson.Gson;

/**
 * 
 * @author Uros Majeric
 * 
 */
public abstract class AbstractItemDataProvider extends AbstractDataProvider {
	protected List<Item> items = new ArrayList<Item>();

	protected AbstractItemDataProvider(String kpiName) {
		super(kpiName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Collection<KPI> getKPIs() {
		ArrayList<KPI> kpis = new ArrayList<KPI>();

		Gson gson = new Gson();

		List<String> labels = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		List<Object> changes = new ArrayList<Object>();
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if (item != null) {
				labels.add(item.getLabel());
				values.add(item.getValue());
				changes.add(item.getChange());
			}
		}

		kpis.add(new KPI.Builder().setKey(kpiName + "@labels").setValue(gson.toJson(labels)).setDate(date).build());
		kpis.add(new KPI.Builder().setKey(kpiName + "@values").setValue(gson.toJson(values)).setDate(date).build());
		kpis.add(new KPI.Builder().setKey(kpiName + "@changes").setValue(gson.toJson(changes)).setDate(date).build());
		return kpis;
	}

	public void addItem(String label, Object value) {
		addItem(label, value, null);
	}

	public void addItem(String label, Object value, Object change) {
		if (change == null) {
			change = "";
		}
		items.add(new Item(label, value, change));
	}

}
