package com.lg.team3.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.model.MemberModel;
import com.lg.team3.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/addMember")
	@ResponseBody
	// 회원가입
	public JSONObject addMember(HttpServletRequest request) {

		MemberModel memberModel = new MemberModel(0,
				request.getParameter("phoneNo"), request.getParameter("pwd"),
				request.getParameter("name"));
		JSONObject jObject = new JSONObject();
		if(memberService.isJoin(memberModel) == true) {
			jObject.put("isSuccess", "duplicated");
			return jObject;
		}
		
		if (memberService.addMember(memberModel) == true) {
			jObject.put("isSuccess", "true");
		} else {
			jObject.put("isSuccess", "false");
		}
		return jObject;
	}

	@RequestMapping("/checkJoin")
	@ResponseBody
	public JSONObject isJoin(HttpServletRequest request) {

		MemberModel memberModel = new MemberModel(0,
				request.getParameter("phoneNo"), request.getParameter("pwd"),
				"");
		//MemberModel memberModel = new MemberModel(0, "23123232","23232","");
		boolean result = memberService.isJoin(memberModel);

		/* make json string */
		JSONObject jObject = new JSONObject();
		if (result == true) {
			jObject.put("isSuccess", "true");
		} else {
			jObject.put("isSuccess", "false");
		}
		/* make json string */
		 System.out.println(result);
		return jObject;
	}
}
