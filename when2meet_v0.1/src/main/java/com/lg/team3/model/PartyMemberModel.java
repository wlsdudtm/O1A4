package com.lg.team3.model;

public class PartyMemberModel {
	private int id;
	private int memberId;
	private int partyId;
	
	public PartyMemberModel() {
	}
	
	public PartyMemberModel(int id, int memberId, int partyId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.partyId = partyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	@Override
	public String toString() {
		return "PartyMemberModel [id=" + id + ", memberId=" + memberId
				+ ", partyId=" + partyId + "]";
	}
	
	
}
