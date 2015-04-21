package com.lg.team3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.MemberDao;
import com.lg.team3.dao.PartyDao;
import com.lg.team3.model.MemberModel;
import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.model.PartyModel;

@Service
public class PartyService {
	@Autowired
	PartyDao partyDao;

	public boolean addPartyAndMember(PartyModel partyModel, MemberModel memberModel) {
		if (partyDao.addParty(partyModel) == false) {
			return false;
		}
		System.out.println("addParty!!");
		int lastPartyModelId = partyDao.getLastParty(memberModel.getId());
		System.out.println("lastPartyModelId: " + lastPartyModelId);
		System.out.println("get lastPartyModel!!");
		PartyMemberModel partyMemberModel = new PartyMemberModel(0, memberModel.getId(), lastPartyModelId);
		
		if (partyDao.addPartyMember(partyMemberModel) == false) {
			//TODO: 파티 삭제
			return false;
		}
		System.out.println("addPartyMember!!");
		return true;
	}
}
