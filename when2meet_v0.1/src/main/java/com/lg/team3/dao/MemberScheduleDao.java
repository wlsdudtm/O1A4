package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.MemberScheduleModel;

public class MemberScheduleDao extends SqlSessionDaoSupport {
	private final String namespace = "com.lg.team3.memberSchedule.";

	public boolean insertMemberSchedule(MemberScheduleModel memberScheduleModel) {
		System.out.println("머지");
		int result = getSqlSession().insert(namespace + "insertMemberSchedule", memberScheduleModel);
		System.out.println("머지");
		return (result !=0 )? (true):(false) ;
	}

}
