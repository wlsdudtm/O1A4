package com.lg.team3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.MemberDao;
import com.lg.team3.dao.PartyDao;
import com.lg.team3.dao.PartyMemberDao;
import com.lg.team3.model.MemberModel;
import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.model.PartyModel;

@Service
public class PartyService {
	@Autowired
	PartyDao partyDao;
	PartyMemberDao partyMemberDao;

	public boolean addPartyAndMember(PartyModel partyModel, MemberModel memberModel) {
		if (partyDao.addParty(partyModel) == false) {
			return false;
		}
		partyModel = partyDao.getLastParty(memberModel.getId());
		PartyMemberModel partyMemberModel = new PartyMemberModel(0, memberModel.getId(), partyModel.getId());
		
		if (partyMemberDao.addPartyMember(partyMemberModel) == false) {
			partyDao.deleteParty(partyModel.getId());
			return false;
		}
		return true;
	}
	
	public boolean deleteParty(int partyId) {
		
		return partyDao.deleteParty(partyId);
	}
}
