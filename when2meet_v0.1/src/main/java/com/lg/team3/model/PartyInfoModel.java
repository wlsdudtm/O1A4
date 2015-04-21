package com.lg.team3.model;

import java.util.List;

public class PartyInfoModel {
	
	private int partyId;
	private List<MemberModel> memberList;
	private String title;
	private int isProgress;
	
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public List<MemberModel> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<MemberModel> memberList) {
		this.memberList = memberList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIsProgress() {
		return isProgress;
	}
	public void setIsProgress(int isProgress) {
		this.isProgress = isProgress;
	}
	@Override
	public String toString() {
		return "PartyListModel [partyId=" + partyId + ", memberList="
				+ memberList + ", title=" + title + ", isProgress="
				+ isProgress + "]";
	}
	
}
