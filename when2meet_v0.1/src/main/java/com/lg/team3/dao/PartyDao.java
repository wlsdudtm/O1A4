package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class PartyDao extends SqlSessionDaoSupport{
	private final String partyNamespace = "com.lg.team3.party.";
	private final String partyMemberNameSpace = "com.lg.team3.partyMember";
}
