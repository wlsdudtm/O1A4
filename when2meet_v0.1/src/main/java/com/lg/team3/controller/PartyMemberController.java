package com.lg.team3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.service.PartyMemberService;
import com.lg.team3.service.PartyService;

@Controller
public class PartyMemberController {
	@Autowired
	PartyMemberService partyMemberService;
	@Autowired
	PartyService partyService;

	@RequestMapping("/getPartyList")
	@ResponseBody
	public String getMyPartyInfo(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		JSONObject json = new JSONObject();
		System.out.println("id : "+request.getParameter("id"));
		List<PartyMemberModel> partyList = partyMemberService
				.getMyPartyInfo(request.getParameter("id"));
		
		json.put("partyList", JSONArray.fromObject(partyList));
		System.out.println(json);
		return json.toString();
	}
	
	@RequestMapping("/deletePartyMember")
	@ResponseBody
	public String deletePartyMember(HttpServletRequest request){
		
		PartyMemberModel partyMemberModel = new PartyMemberModel();
		
		partyMemberModel.setMemberId(request.getParameter("memberId"));
		partyMemberModel.setPartyId(Integer.parseInt(request.getParameter("partyId")));
		
		JSONObject jObject = new JSONObject();
		
		if(partyMemberService.deletePartyMember(partyMemberModel)){
			jObject.put("isSuccess", "true");
		}else{
			jObject.put("isSuccess", "false");
		}
		return jObject.toString();
	}
	
	@RequestMapping("/inviteMember")
	@ResponseBody
	public String inviteMember(HttpServletRequest request){
		String memberId = request.getParameter("memberId");
		String partyId = request.getParameter("partyId");
		
		PartyMemberModel partyMemberModel = new PartyMemberModel(0, memberId, Integer.parseInt(partyId), null);
		JSONObject jObject = new JSONObject();
		
		if(partyService.insertPartyMember(partyMemberModel)){
			jObject.put("isSuccess", "true");
		}else{
			jObject.put("isSuccess", "false");
		}
		
		return jObject.toString();
	}
}
