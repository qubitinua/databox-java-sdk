package com.databox.sdk.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.databox.sdk.kpi.KPI;
import com.google.gson.Gson;

/**
 * Helper data provider for the Messages widget.
 * 
 * @author Uros Majeric
 * 
 */
public class MessagesDataProvider extends AbstractDataProvider {
	private List<String> messages = new ArrayList<String>();

	/**
	 * 
	 * @param kpiName
	 *            used when the custom connection was created on WEB app page.
	 */
	public MessagesDataProvider(String kpiName) {
		super(kpiName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Collection<KPI> getKPIs() {
		ArrayList<KPI> kpis = new ArrayList<KPI>();

		if (messages != null && !messages.isEmpty()) {
			Gson gson = new Gson();
			kpis.add(new KPI.Builder().setKey(kpiName).setValue(gson.toJson(messages)).setDate(date).build());
		}
		return kpis;
	}

	public void add(String message) {
		messages.add(message);
	}
}
