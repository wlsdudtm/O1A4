package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MemberDao extends SqlSessionDaoSupport{
	private final String namespace = "com.lg.team3.member.";
}
