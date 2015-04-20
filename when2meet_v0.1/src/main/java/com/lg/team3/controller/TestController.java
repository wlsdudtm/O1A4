package com.lg.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lg.team3.model.MemberModel;
import com.lg.team3.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	TestService ser;
	
	@RequestMapping("/move")
	public String go(Model model){
		
		//MemberModel m = ser.test();
		int m = ser.test();
		System.out.println(m);
		return "test";
	}
}
