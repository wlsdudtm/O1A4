package com.lg.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lg.team3.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
}
