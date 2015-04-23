package com.lg.team3.controller;

//import net.sf.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.team3.model.MScheduleInfoModel;
import com.lg.team3.model.MemberModel;
import com.lg.team3.model.MemberScheduleModel;
import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.service.MemberScheduleService;
import com.lg.team3.service.MemberService;
import com.lg.team3.service.PartyMemberService;

@Controller
public class MemberScheduleController {
	@Autowired
	MemberScheduleService memberScheduleService;
	@Autowired
	MemberService memberService;
	@Autowired
	PartyMemberService partyMemberService;

	@RequestMapping("/insertMemberSchedule")
	@ResponseBody
	public JSONObject insertMemberSchedule(HttpServletRequest request) {
		JSONObject jObject = new JSONObject();
		System.out.println("@@@ insertMemberSchedule");
		/* Login Check */
		MemberModel memberModel = new MemberModel(
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
		// String data = "[{\"partyId\":\"1\", \"memberId\":\"010\", \"year\":\"2015\", "
		// + "\"month\":\"1\", \"day\":\"2\",\"hour\":\"12\"}, "
		// + "{\"partyId\":\"1\", \"memberId\":\"010\" , \"year\":\"2015\", "
		// + "\"month\":\"1\", \"day\":\"3\",\"hour\":\"12\"}]";
		JSONObject selectData = null;
		JSONArray jsonArray = null;
		try {
			System.out.println("@@ ggg "+data);
			jsonArray = (JSONArray) parser.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < jsonArray.size(); i++) {
			selectData = (JSONObject) jsonArray.get(i);
			System.out.println("@@ "+selectData);
			String partyId = selectData.get("partyId").toString();
			String memberId = selectData.get("memberId").toString();
			PartyMemberModel partyMemberModel = new PartyMemberModel(0, memberId, Integer.parseInt(partyId), null);
			int partyMemberId = partyMemberService.getPartyMemberId(partyMemberModel);
			
			MemberScheduleModel memberScheduleModel = new MemberScheduleModel(
					0, partyMemberId, Integer.parseInt(selectData.get(
							"year").toString()), Integer.parseInt(selectData
							.get("month").toString()),
					Integer.parseInt(selectData.get("day").toString()),
					Integer.parseInt(selectData.get("hour").toString()));
			try {
				memberScheduleService.insertMemberSchedule(memberScheduleModel);
				System.out.println("SUCCESS ADD!!! : " + selectData);
			} catch (Exception e) {
				System.out.println("addSelectedTime Error!!! : " + selectData);
				//e.printStackTrace();
			}
		}
		/* get jsonArray */

		jObject.put("isSuccess", "true");

		return jObject;
	}
	
	
	@RequestMapping("/updateMemberSchedule")
	@ResponseBody
	public String updateMemberSchedule(HttpServletRequest request){
		JSONObject jObject = new JSONObject();
		JSONParser parser = new JSONParser();
		String data = request.getParameter("data");
		
		String partyIdparam =  request.getParameter("partyId");
		String memberIdparam =  request.getParameter("memberId");
		
		PartyMemberModel partyMemberModelTmp = new PartyMemberModel(0, memberIdparam, Integer.parseInt(partyIdparam), null);
		int partyMemberIdTmp = partyMemberService.getPartyMemberId(partyMemberModelTmp);
		List<MemberScheduleModel> serverScheduleList 
				= memberScheduleService.getMemberScheduleById(partyMemberIdTmp);
		if(data.equals("[]")){
			for(MemberScheduleModel serverSchedule : serverScheduleList){
				memberScheduleService.deleteMemberSchedule(serverSchedule.getId());
			}
		}else{
			JSONObject selectData = null;
			JSONArray jsonArray = null;
			try {
				jsonArray = (JSONArray) parser.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//클라이언트가 보낸 스케줄
			List<MemberScheduleModel> clientScheduleList = null;
			
			for (int i = 0; i < jsonArray.size(); i++) {
				clientScheduleList = new ArrayList<MemberScheduleModel>();
				selectData = (JSONObject) jsonArray.get(i);

				String partyId = selectData.get("partyId").toString();
				String memberId = selectData.get("memberId").toString();
				
				PartyMemberModel partyMemberModel = new PartyMemberModel(0, memberId, Integer.parseInt(partyId), null);
				int partyMemberId = partyMemberService.getPartyMemberId(partyMemberModel);
				
				MemberScheduleModel clientSchedule = new MemberScheduleModel(
						0, partyMemberId, Integer.parseInt(selectData.get(
								"year").toString()), Integer.parseInt(selectData
								.get("month").toString()),
						Integer.parseInt(selectData.get("day").toString()),
						Integer.parseInt(selectData.get("hour").toString()));
			
				clientScheduleList.add(clientSchedule);
				serverScheduleList = memberScheduleService.getMemberScheduleById(partyMemberId);
			
				int flag = 0;
				
				for(MemberScheduleModel serverSchedule : serverScheduleList){
					if(clientSchedule.getYear() == serverSchedule.getYear()
							&& clientSchedule.getMonth() == serverSchedule.getMonth()
							&& clientSchedule.getDay() == serverSchedule.getDay()
							&& clientSchedule.getHour() == serverSchedule.getHour()){
						flag=1;
					}
				}
				
				if(flag==0){
					try{
						memberScheduleService.insertMemberSchedule(clientSchedule);
					}catch(Exception e){
						
					}
				}
			}
			
			for(MemberScheduleModel serverSchedule : serverScheduleList){
				int flag = 0;
				for(MemberScheduleModel clientSchedule : clientScheduleList){
					if(clientSchedule.getYear() == serverSchedule.getYear()
							&& clientSchedule.getMonth() == serverSchedule.getMonth()
							&& clientSchedule.getDay() == serverSchedule.getDay()
							&& clientSchedule.getHour() == serverSchedule.getHour()){
						flag = 1;
					}
				}
				if(flag == 0){
					memberScheduleService.deleteMemberSchedule(serverSchedule.getId());
				}
			}
		}
		
		jObject.put("isSuccess", "true");
		
		return jObject.toString();
	}

	@RequestMapping("/getMemberSchedule")
	@ResponseBody
	public String getMemberSchedule(HttpServletRequest request) {

		JSONObject jObject = new JSONObject();

		List<MScheduleInfoModel> selectedTimeList = memberScheduleService
				.getMemberSchedule(Integer.parseInt(request
						.getParameter("partyId")));

		jObject.put("voteList",
				net.sf.json.JSONArray.fromObject(selectedTimeList));
		System.out.println("getMemberSchedule : " + jObject);
		
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