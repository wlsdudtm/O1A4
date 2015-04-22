package com.lg.team3.model;

import java.util.List;

public class PartyModel {
	private int id;
	private String title;
	private int fromHour;
	private int toHour;
	private List<MemberModel> memberList;
	
	public PartyModel() {
	}

	public PartyModel(int id, String title, int fromHour, int toHour,
			List<MemberModel> memberList) {
		super();
		this.id = id;
		this.title = title;
		this.fromHour = fromHour;
		this.toHour = toHour;
		this.memberList = memberList;
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

	public List<MemberModel> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberModel> memberList) {
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "PartyModel [id=" + id + ", title=" + title + ", fromHour="
				+ fromHour + ", toHour=" + toHour + ", memberList="
				+ memberList + "]";
	}

	
}
