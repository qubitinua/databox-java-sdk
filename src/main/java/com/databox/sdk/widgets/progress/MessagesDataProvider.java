package com.databox.sdk.widgets.progress;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.databox.sdk.kpi.KPI;
import com.databox.sdk.widgets.AbstractBuilder;
import com.databox.sdk.widgets.AbstractDataProvider;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class MessagesDataProvider extends AbstractDataProvider {
	private List<String> messages = new ArrayList<String>();

	protected MessagesDataProvider() {
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

	public static class Builder extends AbstractBuilder<MessagesDataProvider> {
		protected List<String> messages = new ArrayList<String>();

		@Override
		protected MessagesDataProvider newDataProvider() {
			return new MessagesDataProvider();
		}

		@Override
		protected void buildImpl(MessagesDataProvider dataProvider) {
			dataProvider.messages.addAll(messages);
		}

		public void add(String message) {
			messages.add(message);
		}
	}
}
