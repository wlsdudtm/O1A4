package com.lg.team3.controller;

import javax.servlet.http.HttpServletRequest;

//import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.model.MemberModel;
import com.lg.team3.model.SelectedTimeModel;
import com.lg.team3.service.MemberService;
import com.lg.team3.service.SelectedTimeService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Controller
public class SelectedTimeController {
	@Autowired
	SelectedTimeService selectedTimeService;
	@Autowired
	MemberService memberService;

	@RequestMapping("/addSelectedTime")
	@ResponseBody
	public JSONObject addSelectedTime(HttpServletRequest request) {
		JSONObject jObject = new JSONObject();

		/* Login Check */
		MemberModel memberModel = new MemberModel(0,
				request.getParameter("phoneNo"), request.getParameter("pwd"),
				"");
		// check is join
		if (memberService.isJoin(memberModel) == null) {
			jObject.put("isSuccess", "false");
			return jObject;
		}
		/* Login Check */

		/* get jsonArray */
		JSONParser parser = new JSONParser();
		String data = request.getParameter("data");
		// String data = "[{\"partyMemberId\":\"1\", \"year\":\"2015\", "
		// +
		// "\"month\":\"1\", \"day\":\"2\",\"fromHour\":\"12\",\"toHour\":\"15\"}, "
		// + "{\"partyMemberId\":\"1\", \"year\":\"2015\", "
		// +
		// "\"month\":\"1\", \"day\":\"3\",\"fromHour\":\"12\",\"toHour\":\"20\"}]";
		JSONObject selectData = null;
		JSONArray jsonArray = null;
		try {
			jsonArray = (JSONArray) parser.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < jsonArray.size(); i++) {

			selectData = (JSONObject) jsonArray.get(i);

			SelectedTimeModel selectedTimeModel = new SelectedTimeModel(
					0,
					Integer.parseInt(selectData.get("partyMemberId").toString()),
					Integer.parseInt(selectData.get("year").toString()),
					Integer.parseInt(selectData.get("month").toString()),
					Integer.parseInt(selectData.get("day").toString()), 
					Integer.parseInt(selectData.get("fromHour").toString()),
					Integer.parseInt(selectData.get("toHour").toString()));

			if (selectedTimeService.addSelectedTime(selectedTimeModel) == false) {
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