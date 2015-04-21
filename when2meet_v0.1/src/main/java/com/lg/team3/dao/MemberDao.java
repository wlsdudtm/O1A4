package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.MemberModel;

public class MemberDao extends SqlSessionDaoSupport{
	private final String namespace = "com.lg.team3.member.";
	
	public boolean addMember(MemberModel memberModel){
		int result = getSqlSession().insert(namespace+"addMember", memberModel);
		return (result != 0)? (true):(false);
	}
	
	public boolean isJoin(MemberModel memberModel){
		int result = getSqlSession().selectOne(namespace+"isJoin", memberModel);
		return (result != 0)? (true):(false);
	}
	
	public boolean isExist(MemberModel memberModel){
		int result = getSqlSession().selectOne(namespace+"isExist", memberModel);
		return (result != 0)? (true):(false);
	}

	public MemberModel getMember(String phoneNo) {
		return getSqlSession().selectOne(namespace+"getMember", phoneNo);
	}
}
