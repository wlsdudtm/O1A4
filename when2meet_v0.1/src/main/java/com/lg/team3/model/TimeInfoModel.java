package com.lg.team3.model;

public class TimeInfoModel {
	private String phoneNo;
	private String name;
	private int year;
	private int month;
	private int day;
	private int fromHour;
	private int toHour;
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
		return "TimeInfoModel [phoneNo=" + phoneNo + ", name=" + name
				+ ", year=" + year + ", month=" + month + ", day=" + day
				+ ", fromHour=" + fromHour + ", toHour=" + toHour + "]";
	}
	
	
}
