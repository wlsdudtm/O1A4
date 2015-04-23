package com.lg.team3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.MemberScheduleDao;
import com.lg.team3.model.MScheduleInfoModel;
import com.lg.team3.model.MemberScheduleModel;

@Service
public class MemberScheduleService {
	@Autowired
	MemberScheduleDao memberScheduleDao;

	public boolean insertMemberSchedule(MemberScheduleModel memberScheduleModel) {
		return memberScheduleDao.insertMemberSchedule(memberScheduleModel);
	}
	
	public List<MScheduleInfoModel> getMemberSchedule(int partyId){
		return memberScheduleDao.getMemberSchedule(partyId);
	}
	
	public List<MemberScheduleModel> getMemberScheduleById(int partyMemberId){
		return memberScheduleDao.getMemberScheduleById(partyMemberId);
	}
	
	public boolean deleteMemberSchedule(int id){
		return memberScheduleDao.deleteMemberSchedule(id);
	}
	
	public int isExistMemberSchedule(MemberScheduleModel memberScheduleModel){
		return memberScheduleDao.isExistMemberSchedule(memberScheduleModel);
	}
}
