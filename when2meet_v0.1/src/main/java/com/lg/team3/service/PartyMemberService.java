package com.lg.team3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.PartyMemberDao;
import com.lg.team3.model.MemberModel;
import com.lg.team3.model.PartyInfoModel;
import com.lg.team3.model.PartyMemberModel;

@Service
public class PartyMemberService {
	
	@Autowired
	PartyMemberDao partyMemberDao;
	
	// 로그인한 멤버의 파티목록 가져오기( 파티 정보 & 그 파티에 가입한 멤버들 정보 )
	public List<PartyMemberModel> getMyPartyInfo(int id){
		List<PartyMemberModel> partyMemberList = partyMemberDao.getMyParty(id);
		
		for(PartyMemberModel partyMember : partyMemberList){
			partyMember.setPartyInfo(partyMemberDao.getMyPartyInfo(partyMember.getPartyId()));
		}
		
		return partyMemberList;
	}
	
	public boolean insertPartyMember(PartyMemberModel partyMemberModel) {
		return partyMemberDao.addPartyMember(partyMemberModel);
	}

	public boolean deletePartyMember(PartyMemberModel partyMemberModel) {
		
		return partyMemberDao.deletePartyMember(partyMemberModel);
	}

	public boolean isPartyEmpty(int partyId) {
		List<PartyMemberModel> partyMemberModels = partyMemberDao.getPartyMemberList(partyId);
		System.out.println(partyMemberModels.size());
		if (partyMemberModels.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
