package com.lg.team3.model;


public class MScheduleInfoModel {
	
	private String id;
	private String name;
	private int year;
	private int month;
	private int day;
	private int hour;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "MScheduleInfoModel [id=" + id + ", name=" + name + ", year="
				+ year + ", month=" + month + ", day=" + day + ", hour=" + hour
				+ "]";
	}
	
}
