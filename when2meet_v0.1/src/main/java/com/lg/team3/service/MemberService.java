package com.lg.team3.service;

import java.util.List;

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

	// 로그인 체크
	public MemberModel isJoin(MemberModel memberModel) {
		return memberDao.isJoin(memberModel);
	}
	
	// 아이디 존재 여부 확인
	public MemberModel isExist(MemberModel memberModel) {
		return memberDao.isExist(memberModel);
	}

	//아이디가 포함된 멤버들 가져오기
	public List<MemberModel> getMembersById(String memberId){
		return memberDao.getMembersById(memberId);
	}
}
