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
	
	public List<MemberScheduleModel> getMemberScheduleById(int partyMemberId){
		return getSqlSession().selectList(namespace+"getMemberScheduleById", partyMemberId);
	}
	
	public boolean deleteMemberSchedule(int id){
		return getSqlSession().delete(namespace+"deleteMemberSchedule", id)>0?true:false;
	}
	
	public int isExistMemberSchedule(MemberScheduleModel memberScheduleModel){
		return getSqlSession().selectOne(namespace+"isExistMemberSchedule", memberScheduleModel);
	}
	
}
