package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.MemberModel;


public class TestDao extends SqlSessionDaoSupport {
	final String namespace = "com.lg.team3.";
	public int test(){
		return (getSqlSession().selectOne("com.lg.team3.all"));
	}
	
	public int insert(MemberModel m){
		return getSqlSession().insert(namespace+"insert", m);
	}
}
