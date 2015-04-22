package com.lg.team3.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.model.PartyModel;
import com.lg.team3.model.PartyScheduleModel;

public class PartyMemberDao extends SqlSessionDaoSupport {
	private final String namespace = "com.lg.team3.partyMember.";
	private final String pScheduleNamespace = "com.lg.team3.partySchedule.";

	public List<PartyMemberModel> getMyParty(String id) {
		return getSqlSession().selectList(namespace + "getMyParty", id);
	}

	public PartyModel getMyPartyInfo(int id) {
		return getSqlSession().selectOne(namespace + "getMyPartyInfo", id);
	}

	public boolean insertPartySchedule(PartyScheduleModel partyScheduleModel) {
		int result = getSqlSession().insert(
				pScheduleNamespace + "insertPartySchedule", partyScheduleModel);
		return (result != 0) ? (true) : (false);
	}

	public boolean insertPartyMember(PartyMemberModel partyMemberModel) {
		int result = getSqlSession().insert(namespace + "insertPartyMember",
				partyMemberModel);
		return (result != 0) ? (true) : (false);
	}
	
	public boolean deletePartyMember(PartyMemberModel partyMemberModel){
		return getSqlSession().delete(namespace+"deletePartyMember", partyMemberModel)>0?true:false;
	}
	
	public int isExistPartyMember(int partyId){
		return getSqlSession().selectOne(namespace+"isExistPartyMember", partyId);
	}
	
	public int getPartyMemberId(PartyMemberModel partyMemberModel){
		return getSqlSession().selectOne(namespace+"getPartyMemberId", partyMemberModel);
	}
}
