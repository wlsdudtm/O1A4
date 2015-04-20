package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.MemberModel;


public class TestDao extends SqlSessionDaoSupport {
	public int test(){
		return (getSqlSession().selectOne("com.lg.team3.all"));
	}
}
