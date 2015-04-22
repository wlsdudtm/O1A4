package com.lg.team3.model;

public class PartyMemberModel {
	private int id;
	private String memberId;
	private int partyId;
	private PartyModel partyInfo;

	public PartyMemberModel() {
	}

	public PartyMemberModel(int id, String memberId, int partyId,
			PartyModel partyInfo) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.partyId = partyId;
		this.partyInfo = partyInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	public PartyModel getPartyInfo() {
		return partyInfo;
	}

	public void setPartyInfo(PartyModel partyInfo) {
		this.partyInfo = partyInfo;
	}

	@Override
	public String toString() {
		return "PartyMemberModel [id=" + id + ", memberId=" + memberId
				+ ", partyId=" + partyId + ", partyInfo=" + partyInfo + "]";
	}

}
