package com.lg.team3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.PartyDao;
import com.lg.team3.dao.PartyMemberDao;
import com.lg.team3.model.PartyInfoModel;
import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.model.PartyModel;
import com.lg.team3.model.PartyScheduleModel;

@Service
public class PartyService {
	@Autowired
	PartyDao partyDao;
	@Autowired
	PartyMemberDao partyMemberDao;
	public boolean insertParty(PartyModel partyModel) {
		return partyDao.insertParty(partyModel);
	}
	public boolean insertPartySchedule(PartyScheduleModel partyScheduleModel) {
		return partyMemberDao.insertPartySchedule(partyScheduleModel);
	}
	public PartyModel getLastParty(String master_id) {
		return partyDao.getLastParty(master_id);
	}
	public boolean insertPartyMember(PartyMemberModel partyMemberModel) {
		return partyMemberDao.insertPartyMember(partyMemberModel);
	}
	public PartyModel getPartyById(int partyId){
		return partyDao.getPartyById(partyId);
	}
	
	public List<PartyInfoModel> getPartyInfo(int partyId){
		return partyDao.getPartyInfo(partyId);
		
	}
}
