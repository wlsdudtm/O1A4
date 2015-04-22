package com.lg.team3.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.MScheduleInfoModel;
import com.lg.team3.model.MemberScheduleModel;

public class MemberScheduleDao extends SqlSessionDaoSupport {
	private final String namespace = "com.lg.team3.memberSchedule.";

	public boolean insertMemberSchedule(MemberScheduleModel memberScheduleModel) {
		int result = getSqlSession().insert(namespace + "insertMemberSchedule", memberScheduleModel);
		return (result !=0 )? (true):(false) ;
	}

	public List<MScheduleInfoModel> getMemberSchedule(int partyId){
		return getSqlSession().selectList(namespace+"getMemberSchedule", partyId);
	}
	
}
