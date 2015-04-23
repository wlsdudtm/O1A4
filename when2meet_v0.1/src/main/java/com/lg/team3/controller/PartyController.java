package com.lg.team3.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.model.MemberModel;
import com.lg.team3.model.PartyInfoModel;
import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.model.PartyModel;
import com.lg.team3.model.PartyScheduleModel;
import com.lg.team3.service.MemberService;
import com.lg.team3.service.PartyService;

@Controller
public class PartyController {
	@Autowired
	MemberService memberService;
	@Autowired
	PartyService partyService;

	@RequestMapping("/createParty")
	@ResponseBody
	public JSONObject createParty(HttpServletRequest request) {
		JSONObject jObject = new JSONObject();
		
		/* Login Check */
		MemberModel memberModel = new MemberModel(
				request.getParameter("id"), request.getParameter("pwd"),
				"");
		// check is join
		memberModel = memberService.isJoin(memberModel);
		if (memberModel == null) {
			jObject.put("isSuccess", "false");
			return jObject;
		}
		/* Login Check */

		String title = request.getParameter("title");
		int fromHour = Integer.parseInt(request.getParameter("fromHour"));
		int toHour = Integer.parseInt(request.getParameter("toHour"));
		String partySchedule = request.getParameter("partySchedule"); //JSON
		System.out.println( partySchedule);
//		String partySchedule = "[{\"year\":\"2015\", \"month\":\"4\", \"day\":\"15\"},"
//				+ "{\"year\":\"2015\", \"month\":\"4\", \"day\":\"16\"},"
//				+ "{\"year\":\"2015\", \"month\":\"4\", \"day\":\"17\"}]";
		PartyModel partyModel = new PartyModel(0, title, fromHour, toHour, memberModel.getId(), null);
		//PartyModel partyModel = new PartyModel(0, "Yaho!", 10, 12, "010", null);	//TODO: master id 수정

		partyService.insertParty(partyModel);
		partyModel = partyService.getLastParty(memberModel.getId());	//TODO: master_id 수정
		System.out.println(partyModel);
		JSONParser parser = new JSONParser();
		JSONObject selectData = null;
		JSONArray jsonArray = null;
		try {
			jsonArray = (JSONArray) parser.parse(partySchedule);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < jsonArray.size(); i++) {
			selectData = (JSONObject) jsonArray.get(i);
			PartyScheduleModel partyScheduleModel = new PartyScheduleModel(0,
					partyModel.getId(),
					Integer.parseInt(selectData.get("year").toString()),
					Integer.parseInt(selectData.get("month").toString()),
					Integer.parseInt(selectData.get("day").toString()));
			System.out.println(partyScheduleModel);
			if (partyService.insertPartySchedule(partyScheduleModel) == true) {
				System.out.println("등록!!");				
			}
		}
		PartyMemberModel partyMemberModel = new PartyMemberModel(0, memberModel.getId(), partyModel.getId(), null);
		partyService.insertPartyMember(partyMemberModel);

		jObject.put("isSuccess", "true");
		jObject.put("partyId", partyModel.getId());
		
		return jObject;
	}
	
	@RequestMapping("/getPartyInfo")
	@ResponseBody
	public String getPartyInfo(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		JSONObject jObject = new JSONObject();
		List<PartyInfoModel> partyInfoList = partyService.getPartyInfo(Integer.parseInt(request.getParameter("partyId")));
		System.out.println(partyInfoList);
		jObject.put("partyInfoList", net.sf.json.JSONArray.fromObject(partyInfoList));
		String str = jObject.toString();
		String encode_str = "";
		try {
			encode_str = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encode_str;
	}
}
