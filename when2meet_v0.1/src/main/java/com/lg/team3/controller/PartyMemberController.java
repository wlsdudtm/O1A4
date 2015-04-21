package com.lg.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lg.team3.service.PartyMemberService;

@Controller
public class PartyMemberController {
	@Autowired
	PartyMemberService partyMemberService;
	
	@RequestMapping("/getMyParty")
	public void getMyPartyInfo(){
		System.out.println(partyMemberService.getMyPartyInfo(1));
	}
}
