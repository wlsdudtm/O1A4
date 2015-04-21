package com.lg.team3.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.MemberModel;

public class PartyMemberDao extends SqlSessionDaoSupport{
	private final String namespace = "com.lg.team3.partyMember.";
	
	public List<MemberModel> getMyParty(int id){
		return getSqlSession().selectList(namespace+"getMyParty", id);
	}
	
}
