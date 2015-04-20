package com.lg.team3.model;

public class MemberModel {
	private int num;
	private String id;
	private String pwd;
	private String name;
	public MemberModel(int num, String id, String pwd, String name) {
		super();
		this.num = num;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "MemberModel [num=" + num + ", id=" + id + ", pwd=" + pwd
				+ ", name=" + name + "]";
	}
	
	
}
