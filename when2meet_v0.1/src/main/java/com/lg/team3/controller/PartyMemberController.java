package com.lg.team3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.service.PartyMemberService;

@Controller
public class PartyMemberController {
	@Autowired
	PartyMemberService partyMemberService;
	
	@RequestMapping("/getPartyList")
	@ResponseBody
	public String getMyPartyInfo(HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		List<PartyMemberModel> partyList = partyMemberService.getMyPartyInfo(Integer.parseInt(request.getParameter("id")));
		
		json.put("partyList", JSONArray.fromObject(partyList));
		System.out.println(json);
		return json.toString();
	}
}
