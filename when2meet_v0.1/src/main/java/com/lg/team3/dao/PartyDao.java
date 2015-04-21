package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.model.PartyModel;

public class PartyDao extends SqlSessionDaoSupport{
	private final String partyNamespace = "com.lg.team3.party.";
	public boolean addParty(PartyModel partyModel) {
		int result = getSqlSession().insert(partyNamespace+"addParty", partyModel);
		System.out.println(result);
		return (result != 0)? (true):(false);
	}

	
	public PartyModel getLastParty(int id) {
		PartyModel partyModel = getSqlSession().selectOne(partyNamespace+"getLastParty", id);
		return partyModel;
	}
	public void deleteParty(PartyModel partyModel) {
		getSqlSession().selectOne(partyNamespace+"deleteParty", partyModel);
	}
}
