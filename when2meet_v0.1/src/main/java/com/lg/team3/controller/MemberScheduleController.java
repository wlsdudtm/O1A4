package com.lg.team3.controller;

//import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lg.team3.service.MemberScheduleService;
import com.lg.team3.service.MemberService;

@Controller
public class MemberScheduleController {
	@Autowired
	MemberScheduleService MemberScheduleService;
	@Autowired
	MemberService memberService;

	
}