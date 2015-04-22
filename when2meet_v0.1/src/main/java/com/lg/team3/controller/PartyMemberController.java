package com.lg.team3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.model.MemberModel;
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
	public String getMyPartyInfo(HttpServletRequest request) {
		JSONObject json = new JSONObject();

		List<PartyMemberModel> partyList = partyMemberService
				.getMyPartyInfo(Integer.parseInt(request.getParameter("id")));

		json.put("partyList", JSONArray.fromObject(partyList));
		System.out.println(json);
		return json.toString();
	}

	@RequestMapping("/insertPartyMember")
	public JSONObject insertPartyMember(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();

		PartyMemberModel partyMemberModel = new PartyMemberModel(0,
				Integer.parseInt(request.getParameter("memberId")),
				Integer.parseInt(request.getParameter("partyId")));
		// PartyMemberModel partyMemberModel = new PartyMemberModel(0, 4, 1);
		System.out.println("insertPartyMember");
		partyMemberService.insertPartyMember(partyMemberModel);

		return jsonObject;
	}

	@RequestMapping("/deletePartyMember")
	public JSONObject deletePartyMember(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();

		PartyMemberModel partyMemberModel = new PartyMemberModel(0,
				Integer.parseInt(request.getParameter("memberId")),
				Integer.parseInt(request.getParameter("partyId")));
//		PartyMemberModel partyMemberModel = new PartyMemberModel(0, 1, 2);
		System.out.println("deletePartyMember");
		partyMemberService.deletePartyMember(partyMemberModel);

		if (partyMemberService.isPartyEmpty(partyMemberModel.getPartyId())) {
			partyService.deleteParty(Integer.parseInt(request
					.getParameter("partyId")));
//			partyService.deleteParty(2);
			System.out.println("partyDeleted!!!");
		}

		return jsonObject;
	}
}
