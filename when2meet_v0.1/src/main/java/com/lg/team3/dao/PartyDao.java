package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.model.PartyModel;

public class PartyDao extends SqlSessionDaoSupport{
	private final String partyNamespace = "com.lg.team3.party.";
	private final String partyMemberNameSpace = "com.lg.team3.partyMember.";
	public boolean addParty(PartyModel partyModel) {
		int result = getSqlSession().insert(partyNamespace+"addParty", partyModel);
		System.out.println(result);
		return (result != 0)? (true):(false);
	}
	public boolean addPartyMember( PartyMemberModel partyMemberModel) {
		int result = getSqlSession().insert(partyMemberNameSpace+"addPartyMember", partyMemberModel);
		return (result != 0)? (true):(false);
	}
	
	public int getLastParty(int id) {
		int partyModelId = getSqlSession().selectOne(partyNamespace+"getLastParty", id);
		return partyModelId;
	}
}
