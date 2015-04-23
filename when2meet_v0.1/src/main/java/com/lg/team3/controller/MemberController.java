package com.lg.team3.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

		MemberModel memberModel = new MemberModel(
				request.getParameter("phoneNo"), request.getParameter("pwd"),
				request.getParameter("name"));
		JSONObject jObject = new JSONObject();
		System.out.println(request.getParameter("name"));
		if(memberService.isExist(memberModel)!=null) {
			jObject.put("isSuccess", "duplicated");
		}else{
			if (memberService.addMember(memberModel) == true) {
				jObject.put("isSuccess", "true");
			} else {
				jObject.put("isSuccess", "false");
			}
		}
		return jObject;
	}

	@RequestMapping("/checkJoin")
	@ResponseBody
	public JSONObject isJoin(HttpServletRequest request) {

		MemberModel memberModel = new MemberModel(
				request.getParameter("phoneNo"), request.getParameter("pwd"),
				"");
		MemberModel result = memberService.isJoin(memberModel);

		/* make json string */
		JSONObject jObject = new JSONObject();
		if (result != null) {
			jObject.put("isSuccess", "true");
			jObject.put("id", result.getId());
			jObject.put("name", result.getName());
		} else {
			jObject.put("isSuccess", "false");
		}
		/* make json string */
		 System.out.println("@@ "+result);
		return jObject;
	}
	
	@RequestMapping("/getMembersById")
	@ResponseBody
	public String getMembersById(HttpServletRequest request){
		JSONObject jObject = new JSONObject();
		
		List<MemberModel> memberList = memberService.getMembersById(request.getParameter("memberId"));
		System.out.println("@@"+ request.getParameter("memberId")+" "+request.getParameter("masterId"));
		//방장아이디 제외
		String masterId = request.getParameter("masterId");
		for(int i = 0 ; i < memberList.size() ; i++) {
			if(masterId.equals(memberList.get(i).getId())) {
				memberList.remove(i);
			}
		}
		System.out.println("@@@ "+memberList);
		jObject.put("memberList", JSONArray.fromObject(memberList));
		
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
