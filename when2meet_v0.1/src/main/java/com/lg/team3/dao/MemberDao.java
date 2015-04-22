package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.MemberModel;

public class MemberDao extends SqlSessionDaoSupport{
	private final String namespace = "com.lg.team3.member.";
	
	public boolean addMember(MemberModel memberModel){
		int result = getSqlSession().insert(namespace+"addMember", memberModel);
		return (result != 0)? (true):(false);
	}
	
	public MemberModel isJoin(MemberModel memberModel){
		return  getSqlSession().selectOne(namespace+"isJoin", memberModel);
	}
	
	public MemberModel isExist(MemberModel memberModel){
		return getSqlSession().selectOne(namespace+"isExist", memberModel);
	}

}
