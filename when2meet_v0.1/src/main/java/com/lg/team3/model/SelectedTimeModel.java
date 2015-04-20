package com.lg.team3.model;

public class SelectedTimeModel {
	private int id;
	private int partyMemberId;
	private int year;
	private int month;
	private int day;
	private int fromHour;
	private int toHour;
	public SelectedTimeModel(int id, int partyMemberId, int year, int month,
			int day, int fromHour, int toHour) {
		super();
		this.id = id;
		this.partyMemberId = partyMemberId;
		this.year = year;
		this.month = month;
		this.day = day;
		this.fromHour = fromHour;
		this.toHour = toHour;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPartyMemberId() {
		return partyMemberId;
	}
	public void setPartyMemberId(int partyMemberId) {
		this.partyMemberId = partyMemberId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
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
	@Override
	public String toString() {
		return "SelectedTimeModel [id=" + id + ", partyMemberId="
				+ partyMemberId + ", year=" + year + ", month=" + month
				+ ", day=" + day + ", fromHour=" + fromHour + ", toHour="
				+ toHour + "]";
	}
	
	
}
