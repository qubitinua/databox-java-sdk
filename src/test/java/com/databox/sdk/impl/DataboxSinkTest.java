package com.databox.sdk.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.databox.sdk.DataSink;
import com.databox.sdk.DefaultDataProvider;
import com.databox.sdk.ResponseWrapper;
import com.databox.sdk.kpi.KPI;
import com.databox.sdk.kpi.KPI.Builder;

public class DataboxSinkTest extends TestCase {
	private static final Logger logger = LoggerFactory.getLogger(DataboxSinkTest.class);

	private DataSink<DataboxCustomConnection> _sink;

	private DataboxCustomConnection _connection;

	@Override
	protected void setUp() throws Exception {
		_sink = new DataboxSink();
		String apiKey = System.getProperty("databox-api-key");
		String appId = System.getProperty("databox-app-id");
		if (apiKey != null && !apiKey.isEmpty() && appId != null && !appId.isEmpty()) {
			_connection = new DataboxCustomConnection(apiKey, appId);
		}
	}

	public void testDatabox() {
		if (_connection != null) {
			Calendar date = new GregorianCalendar(Builder.DEFAULT_TIME_ZONE);
			// reset hour, minutes, seconds and millis
			date.set(Calendar.HOUR_OF_DAY, 0);
			date.set(Calendar.MINUTE, 0);
			date.set(Calendar.SECOND, 0);
			date.set(Calendar.MILLISECOND, 0);

			Calendar yesterday = ((Calendar) date.clone());
			yesterday.roll(Calendar.DAY_OF_YEAR, -1);

			DefaultDataProvider dataProvider = new DefaultDataProvider();
			dataProvider.addKPI(new KPI.Builder().setKey("new_signups").setValue(125D).build());
			dataProvider.addKPI(new KPI.Builder().setKey("new_signups").setValue(205D).setDate(yesterday.getTime()).build());
			_connection.addDataProvider(dataProvider);

			try {
				ResponseWrapper response = _sink.push(_connection);
				logger.info("Response succceeded: {}, with message: '{}'", response.isSucceeded(), response.getMessage());
			} catch (DataPushException e) {
				e.printStackTrace();
			}
		}
	}
}
