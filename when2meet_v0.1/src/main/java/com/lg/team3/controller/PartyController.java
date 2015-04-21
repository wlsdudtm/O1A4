package com.lg.team3.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.model.MemberModel;
import com.lg.team3.model.PartyModel;
import com.lg.team3.service.MemberService;
import com.lg.team3.service.PartyService;

@Controller
public class PartyController {
	@Autowired
	PartyService partyService;
	@Autowired
	MemberService memberService;

	@RequestMapping("/createParty")
	@ResponseBody
	public JSONObject createParty(HttpServletRequest request) {

		MemberModel memberModel = new MemberModel(0,
				request.getParameter("phoneNo"), request.getParameter("pwd"),
				"");
		// MemberModel memberModel = new MemberModel(0, "01028753885", "1234",
		// "");
		// check is join
		if (memberService.isJoin(memberModel) == null) {
			// TODO: return false;
			JSONObject jObject = new JSONObject();
			jObject.put("isSuccess", "false");
			return jObject;
		}
		// get memberModel
		memberModel = memberService.getMember(request.getParameter("phoneNo"));
		// memberModel = memberService.getMember("01028753885");
		// System.out.println(memberModel);

		PartyModel partyModel = new PartyModel(0,
				request.getParameter("title"), Integer.parseInt(request
						.getParameter("fromYear")), Integer.parseInt(request
						.getParameter("toYear")), Integer.parseInt(request
						.getParameter("fromMonth")), Integer.parseInt(request
						.getParameter("toMonth")), Integer.parseInt(request
						.getParameter("fromDay")), Integer.parseInt(request
						.getParameter("toDay")), Integer.parseInt(request
						.getParameter("fromHour")), Integer.parseInt(request
						.getParameter("toHour")), memberModel.getId(), true);

		// PartyModel partyModel = new PartyModel(0,
		// "Yaho", 2014, 2014, 2, 2, 3, 4, 10, 12, 1, true);

		// createParty
		boolean result = partyService
				.addPartyAndMember(partyModel, memberModel);
		/* make json string */
		JSONObject jObject = new JSONObject();
		if (result == true) {
			jObject.put("isSuccess", "true");
		} else {
			jObject.put("isSuccess", "false");
		}
		/* make json string */
		return jObject;
	}
}
