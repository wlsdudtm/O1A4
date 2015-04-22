package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.PartyModel;

public class PartyDao extends SqlSessionDaoSupport{
	
	private final String partyNamespace = "com.lg.team3.party.";
	private final String pScheduleNamespace = "com.lg.team3.partySchedule.";
	public boolean insertParty(PartyModel partyModel) {
		int result = getSqlSession().insert(partyNamespace+"insertParty", partyModel);
		return (result != 0 )?(true):(false);
	}
	public PartyModel getLastParty(String master_id) {
		
		return getSqlSession().selectOne(partyNamespace + "getLastParty", master_id);
	}


}
