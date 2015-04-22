package com.lg.team3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.PartyDao;
import com.lg.team3.dao.PartyMemberDao;
import com.lg.team3.model.PartyInfoModel;
import com.lg.team3.model.PartyMemberModel;

@Service
public class PartyMemberService {
	
	@Autowired
	PartyDao partyDao;
	
	@Autowired
	PartyMemberDao partyMemberDao;
	
	// 로그인한 멤버의 파티목록 가져오기( 파티 정보 & 그 파티에 가입한 멤버들 정보 )
	public List<PartyMemberModel> getMyPartyInfo(String memberId){
		List<PartyMemberModel> partyMemberList = partyMemberDao.getMyParty(memberId);
		System.out.println(partyMemberList);
		for(PartyMemberModel partyMember : partyMemberList){
			partyMember.setPartyInfo(partyMemberDao.getMyPartyInfo(partyMember.getPartyId()));
		}
		
		return partyMemberList;
	}
	
	public boolean deletePartyMember(PartyMemberModel partyMemberModel){
		System.out.println(partyMemberModel);
		//파티 멤버 삭제
		if(partyMemberDao.deletePartyMember(partyMemberModel)){
			
			//파티에 몇 명이 남아있는지 확인
			int count = partyMemberDao.isExistPartyMember(partyMemberModel.getPartyId());
			
			//파티에 아무도 없으면 파티 삭제
			if(count == 0){
				if(partyDao.delteParty(partyMemberModel.getPartyId())){
					System.out.println("파티 삭제 성공");
					return true;
				}else{
					System.out.println("파티 삭제 실패");
					return false;
				}
			}else{
				System.out.println("파티 멤버 삭제 성공 & 파티 삭제 필요없음");
				return true;
			}
		}else{
			System.out.println("파티 멤버 삭제 실패");
			return false;
		}		
	}
	
	public int getPartyMemberId(PartyMemberModel partyMemberModel){
		return partyMemberDao.getPartyMemberId(partyMemberModel);
	}

}
