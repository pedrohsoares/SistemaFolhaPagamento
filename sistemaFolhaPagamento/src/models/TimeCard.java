package models;

import java.util.Calendar;

public class TimeCard {
	private Calendar startDate;
	private Calendar endDate;

	public TimeCard(Calendar startDate, Calendar endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

}
