package com.lg.team3.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.model.PartyModel;

public class PartyMemberDao extends SqlSessionDaoSupport{
	private final String namespace = "com.lg.team3.partyMember.";
	private final String partyMemberNameSpace = "com.lg.team3.partyMember.";
	
	public List<PartyMemberModel> getMyParty(int id){
		return getSqlSession().selectList(namespace+"getMyParty", id);
	}
	
	public PartyModel getMyPartyInfo(int id){
		return getSqlSession().selectOne(namespace+"getMyPartyInfo", id);
	}
	
	public boolean addPartyMember( PartyMemberModel partyMemberModel) {
		int result = getSqlSession().insert(partyMemberNameSpace+"addPartyMember", partyMemberModel);
		return (result != 0)? (true):(false);
	}

	public boolean deletePartyMember(PartyMemberModel partyMemberModel) {
		int result = getSqlSession().delete(partyMemberNameSpace+"deletePartyMember", partyMemberModel);
		return (result != 0)? (true):(false);
	}
	
	public PartyMemberModel getPartyMemberId(PartyMemberModel partyMemberModel){
		return getSqlSession().selectOne(partyMemberNameSpace+"getPartyMemberId", partyMemberModel);
	}
}
