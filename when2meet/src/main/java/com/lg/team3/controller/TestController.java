package com.lg.team3.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	TestService ser;
	
	@RequestMapping("/move")
	@ResponseBody
	public JSONObject go(HttpServletRequest request ,Model model){
		
		String recvMessage = request.getParameter("msg");
		System.out.println(recvMessage+" 허허");
		
		JSONObject jsonMain = new JSONObject();
		JSONArray jArray = new JSONArray();
		
		JSONObject jObject = new JSONObject();

		jObject.put("msg1", recvMessage);
		jObject.put("msg2", "메시지2!");
		jObject.put("msg3", "3번째 메시지!");
		
		jArray.add(0, jObject);

		jsonMain.put("List", jArray);
		
		//model.addAttribute("list", jsonMain.toString());
		
		//out.println(jsonMain.toString());
		//MemberModel m = ser.test();
		//System.out.println(m);
		System.out.println(jsonMain);
		return jsonMain;
		
	}
}
