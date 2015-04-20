package com.lg.team3.model;

public class PartyModel {
	private int id;
	private String title;
	private int fromYear;
	private int toYear;
	private int fromMonth;
	private int toMonth;
	private int fromDay;
	private int toDay;
	private int fromHour;
	private int toHour;
	private int masterId;
	private int isProgress;
	
	public PartyModel(int id, String title, int fromYear, int toYear,
			int fromMonth, int toMonth, int fromDay, int toDay, int fromHour,
			int toHour, int masterId, int isProgress) {
		super();
		this.id = id;
		this.title = title;
		this.fromYear = fromYear;
		this.toYear = toYear;
		this.fromMonth = fromMonth;
		this.toMonth = toMonth;
		this.fromDay = fromDay;
		this.toDay = toDay;
		this.fromHour = fromHour;
		this.toHour = toHour;
		this.masterId = masterId;
		this.isProgress = isProgress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getFromYear() {
		return fromYear;
	}
	public void setFromYear(int fromYear) {
		this.fromYear = fromYear;
	}
	public int getToYear() {
		return toYear;
	}
	public void setToYear(int toYear) {
		this.toYear = toYear;
	}
	public int getFromMonth() {
		return fromMonth;
	}
	public void setFromMonth(int fromMonth) {
		this.fromMonth = fromMonth;
	}
	public int getToMonth() {
		return toMonth;
	}
	public void setToMonth(int toMonth) {
		this.toMonth = toMonth;
	}
	public int getFromDay() {
		return fromDay;
	}
	public void setFromDay(int fromDay) {
		this.fromDay = fromDay;
	}
	public int getToDay() {
		return toDay;
	}
	public void setToDay(int toDay) {
		this.toDay = toDay;
	}
	public int getFromHour() {
		return fromHour;
	}
	public void setFromHour(int fromHour) {
		this.fromHour = fromHour;
	}
	public int getToHour() {
		return toHour;
	}
	public void setToHour(int toHour) {
		this.toHour = toHour;
	}
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public int getIsProgress() {
		return isProgress;
	}
	public void setIsProgress(int isProgress) {
		this.isProgress = isProgress;
	}
	@Override
	public String toString() {
		return "PartyModel [id=" + id + ", title=" + title + ", fromYear="
				+ fromYear + ", toYear=" + toYear + ", fromMonth=" + fromMonth
				+ ", toMonth=" + toMonth + ", fromDay=" + fromDay + ", toDay="
				+ toDay + ", fromHour=" + fromHour + ", toHour=" + toHour
				+ ", masterId=" + masterId + ", isProgress=" + isProgress + "]";
	}
	
}
