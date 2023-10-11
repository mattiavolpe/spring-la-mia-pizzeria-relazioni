package org.java.app.db.pojo;

import java.time.LocalDate;

public class Deal {
	private LocalDate startDate;
	private LocalDate endDate;
	private String title;
	
	public Deal() {}
	
	public Deal(LocalDate startDate, LocalDate endDate, String title) {
		setStartDate(startDate);
		setEndDate(endDate);
		setTitle(title);
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
