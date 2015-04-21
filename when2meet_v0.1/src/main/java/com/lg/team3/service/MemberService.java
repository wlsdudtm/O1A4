package com.lg.team3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.MemberDao;
import com.lg.team3.model.MemberModel;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;

	// 회원가입
	public boolean addMember(MemberModel memberModel) {
		return memberDao.addMember(memberModel);
	}

	public boolean checkJoin(MemberModel memberModel) {
		return memberDao.checkJoin(memberModel);
	}

}
