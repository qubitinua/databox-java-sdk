package com.databox.sdk.kpi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class KPI {
	private String key;
	private Double value;
	private String date;

	/**
	 * Constructor is private by default. Use KPI builder to create new instance.
	 */
	private KPI() {

	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Increments the value for this KPI.
	 * 
	 * @param value
	 *            number with which the current value will be incremented
	 */
	public void incrementValue(Double value) {
		if (this.value == null) {
			this.value = 0D;
		}
		if (value != null) {
			this.value += value;
		}
	}

	@Override
	public String toString() {
		return KPI.class.getSimpleName() + "(" + key + ";" + date + "=" + value + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KPI other = (KPI) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	public static class Builder {
		public static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone("UTC");
		private static SimpleDateFormat SDF;

		private String _key;
		private Double _value;
		private Date _date;
		private boolean _normalized;

		static {
			SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			SDF.setTimeZone(DEFAULT_TIME_ZONE);
		}

		public Builder setKey(String key) {
			_key = key;
			return this;
		}

		public Builder setValue(Double value) {
			_value = value;
			return this;
		}

		public Builder setDate(Date date) {
			_date = date;
			return this;
		}

		public Builder normalized() {
			_normalized = true;
			return this;
		}

		public KPI build() {
			KPI kpi = new KPI();
			if (_key == null || _key.trim().isEmpty()) {
				throw new RuntimeException("Key is KPI's mandatory field!");
			}
			kpi.setKey(_key);
			kpi.setValue(_value);
			if (_date == null) {
				_date = new Date();
			}
			if (_normalized) {
				_date = normalizeDate(_date);
			}
			kpi.setDate(SDF.format(_date));
			return kpi;
		}

		/**
		 * Method normalizes the date to the 00:00:00 time.
		 * 
		 * @return
		 */
		public static Date normalizeDate(Date date) {
			if (date == null) {
				return null;
			}
			Calendar cal = new GregorianCalendar(DEFAULT_TIME_ZONE);
			cal.setTime(date);

			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);

			return cal.getTime();
		}
	}

}
