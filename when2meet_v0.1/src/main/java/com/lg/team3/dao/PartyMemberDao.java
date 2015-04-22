package com.lg.team3.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.model.PartyModel;

public class PartyMemberDao extends SqlSessionDaoSupport{
	private final String namespace = "com.lg.team3.partyMember.";
	
	public List<PartyMemberModel> getMyParty(int id){
		return getSqlSession().selectList(namespace+"getMyParty", id);
	}
	
	public PartyModel getMyPartyInfo(int id){
		return getSqlSession().selectOne(namespace+"getMyPartyInfo", id);
	}
}
