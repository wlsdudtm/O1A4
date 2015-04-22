package com.lg.team3.model;

public class MemberScheduleModel {
	private int id;
	private int partyMemberId;
	private int year;
	private int month;
	private int day;
	private int hour;
	
	public MemberScheduleModel() {
	}

	public MemberScheduleModel(int id, int partyMemberId, int year, int month,
			int day, int hour) {
		super();
		this.id = id;
		this.partyMemberId = partyMemberId;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
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

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "MemberScheduleModel [id=" + id + ", partyMemberId="
				+ partyMemberId + ", year=" + year + ", month=" + month
				+ ", day=" + day + ", hour=" + hour + "]";
	}
	
	
}
