package com.lg.team3.model;

public class MemberModel {
	
	private int id;
	private String phoneNo;
	private String pwd;
	private String name;
	
	public MemberModel() {
	}
	public MemberModel(int id, String phoneNo, String pwd, String name) {
		super();
		this.id = id;
		this.phoneNo = phoneNo;
		this.pwd = pwd;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MemberModel [id=" + id + ", phoneNo=" + phoneNo + ", pwd="
				+ pwd + ", name=" + name + "]";
	}
	
}
