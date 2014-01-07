package com.databox.sdk.widgets.messages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.databox.sdk.kpi.KPI;
import com.databox.sdk.widgets.AbstractDataProvider;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class MessagesDataProvider extends AbstractDataProvider {
	private static final Logger logger = LoggerFactory.getLogger(MessagesDataProvider.class);
	private List<String> messages = new ArrayList<String>();

	public MessagesDataProvider(String kpiName) {
		super(kpiName);
	}

	@Override
	public Collection<KPI> getKPIs() {
		ArrayList<KPI> kpis = new ArrayList<KPI>();

		for (int i = 0; i < messages.size(); i++) {
			String msg = messages.get(i);
			if (msg != null) {
				kpis.add(new KPI.Builder().setKey(kpiName + "@message_" + i).setValue(msg).setDate(date).build());
			}
		}
		return kpis;
	}

	public void add(String message) {
		messages.add(message);
	}
}
