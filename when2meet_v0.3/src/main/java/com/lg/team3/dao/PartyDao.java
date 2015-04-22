package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class PartyDao extends SqlSessionDaoSupport{
	
	private final String partyNamespace = "com.lg.team3.party.";
	private final String pScheduleNamespace = "com.lg.team3.partySchedule.";


}
