package com.lg.team3.controller;

//import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.model.MemberModel;
import com.lg.team3.model.MemberScheduleModel;
import com.lg.team3.service.MemberScheduleService;
import com.lg.team3.service.MemberService;

@Controller
public class MemberScheduleController {
	@Autowired
	MemberScheduleService MemberScheduleService;
	@Autowired
	MemberService memberService;

	@RequestMapping("/insertMemberSchedule")
	@ResponseBody
	public JSONObject insertMemberSchedule(HttpServletRequest request) {
		JSONObject jObject = new JSONObject();

		/* Login Check */
		// MemberModel memberModel = new MemberModel(
		// request.getParameter("phoneNo"), request.getParameter("pwd"),
		// "");
		// // check is join
		// if (memberService.isJoin(memberModel) == null) {
		// jObject.put("isSuccess", "false");
		// return jObject;
		// }
		/* Login Check */

		/* get jsonArray */
		JSONParser parser = new JSONParser();
		// String data = request.getParameter("data");
		String data = "[{\"partyMemberId\":\"1\", \"year\":\"2015\", "
				+ "\"month\":\"1\", \"day\":\"2\",\"hour\":\"12\"}, "
				+ "{\"partyMemberId\":\"1\", \"year\":\"2015\", "
				+ "\"month\":\"1\", \"day\":\"3\",\"hour\":\"12\"}]";
		JSONObject selectData = null;
		JSONArray jsonArray = null;
		try {
			jsonArray = (JSONArray) parser.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < jsonArray.size(); i++) {

			selectData = (JSONObject) jsonArray.get(i);

			MemberScheduleModel memberScheduleModel = new MemberScheduleModel(
					0, Integer.parseInt(selectData.get("partyMemberId")
							.toString()), Integer.parseInt(selectData.get(
							"year").toString()), Integer.parseInt(selectData
							.get("month").toString()),
					Integer.parseInt(selectData.get("day").toString()),
					Integer.parseInt(selectData.get("hour").toString()));

			if (MemberScheduleService.insertMemberSchedule(memberScheduleModel) == false) {
				System.out.println("addSelectedTime Error!!! : " + selectData);
				continue;
			}
			System.out.println("SUCCESS ADD!!! : " + selectData);
		}
		/* get jsonArray */

		jObject.put("isSuccess", "true");

		return jObject;
	}
}