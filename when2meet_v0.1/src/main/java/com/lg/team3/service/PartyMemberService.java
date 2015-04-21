package com.lg.team3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.PartyMemberDao;
import com.lg.team3.model.MemberModel;

@Service
public class PartyMemberService {
	
	@Autowired
	PartyMemberDao partyMemberDao;
	
	public List<MemberModel> getMyParty(int id){
		return partyMemberDao.getMyParty(id);
	}
}
