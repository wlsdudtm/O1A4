package com.lg.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lg.team3.service.PartyMemberService;
import com.lg.team3.service.PartyService;

@Controller
public class PartyMemberController {
	@Autowired
	PartyMemberService partyMemberService;
	@Autowired
	PartyService partyService;


}
