package com.lg.team3.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.model.MemberModel;
import com.lg.team3.service.MemberService;
import com.lg.team3.service.SelectedTimeService;

@Controller
public class SelectedTimeController {
	@Autowired
	SelectedTimeService selectedTimeService;
	@Autowired
	MemberService memberService;

	/*@RequestMapping("/createParty")
	@ResponseBody
	public JSONObject createParty(HttpServletRequest request) {
		JSONObject jObject = new JSONObject();

		MemberModel memberModel = new MemberModel(0,
				request.getParameter("phoneNo"), request.getParameter("pwd"),
				"");
		// check is join
		if (memberService.isJoin(memberModel) == false) {
			// TODO: return false;
			jObject.put("isSuccess", "false");
			return jObject;
		}
//		// get memberModel
//		memberModel = memberService.getMember(request.getParameter("phoneNo"));
		
		boolean result = selectedTimeService.addSelectedTime();

		return jObject;
	}*/
}
