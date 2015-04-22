package com.lg.team3.model;

public class PartyInfoModel {
	private int partyId;
	private int year;
	private int month;
	private int day;
	private String title;
	private int fromHour;
	private int toHour;
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		return "PartyInfoModel [partyId=" + partyId + ", year=" + year
				+ ", month=" + month + ", day=" + day + ", title=" + title
				+ ", fromHour=" + fromHour + ", toHour=" + toHour + "]";
	}
	
	
}
