package com.lg.team3.model;

public class PartyScheduleModel {
	int id;
	int partyId;
	int year;
	int month;
	int day;
	
	public PartyScheduleModel() {
	}

	public PartyScheduleModel(int id, int partyId, int year, int month, int day) {
		super();
		this.id = id;
		this.partyId = partyId;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "PartyScheduleModel [id=" + id + ", partyId=" + partyId
				+ ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
}
