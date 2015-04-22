package com.lg.team3.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.PartyInfoModel;
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

	public boolean delteParty(int partyId){
		return getSqlSession().delete(partyNamespace+"delteParty", partyId)>0?true:false;
	}
	
	public PartyModel getPartyById(int partyId){
		return getSqlSession().selectOne(partyNamespace+"getPartyById", partyId);
	}
	
	public List<PartyInfoModel> getPartyInfo(int partyId){
		return getSqlSession().selectList(pScheduleNamespace+"getPartyInfo", partyId);
	}
}
