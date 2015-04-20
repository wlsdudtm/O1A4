package com.lg.team3.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lg.team3.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	TestService ser;
	
	@RequestMapping("/move")
	public JSONObject go(HttpServletRequest request, Model model){
		
		//MemberModel m = ser.test();
		//int m = ser.test();
		//System.out.println(m);
		
		String recvMessage = request.getParameter("msg");

		JSONObject jsonMain = new JSONObject();
		JSONArray jArray = new JSONArray();
		
		JSONObject jObject = new JSONObject();

		jObject.put("msg1", recvMessage);
		jObject.put("msg2", "메시지2!");
		jObject.put("msg3", "3번째 메시지!");
		
		jArray.add(0, jObject);

		jsonMain.put("List", jArray);
		
		return jsonMain;
	}
}
