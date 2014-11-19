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
	public enum IconType {
		Number, EUR, USD, User, Lead, Ticket;
	}

	private final List<String> messages = new ArrayList<String>();
	private final List<IconType> icons = new ArrayList<IconType>();

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

		if (messages != null && !messages.isEmpty() && icons != null) {
			if (messages.size() != icons.size()) {
				throw new RuntimeException("Wrong number of icons for messages (KPI: " + kpiName + ")!");
			}
			Gson gson = new Gson();
			kpis.add(new KPI.Builder().setKey(kpiName + "@labels").setValue(gson.toJson(messages)).setDate(date).setNormalized(normalized).build());
			/* icons list have to have the same number of elements as messages */
			kpis.add(new KPI.Builder().setKey(kpiName + "@icons").setValue(gson.toJson(icons)).setDate(date).setNormalized(normalized)
					.build());
		}
		return kpis;
	}

	/**
	 * Add message with default icon type (IconType.Number).
	 */
	public void add(String message) {
		this.add(message, IconType.Number);
	}

	/**
	 * Add message with icon type.
	 */
	public void add(String message, IconType iconType) {
		messages.add(message);
		icons.add(iconType);
	}
}
