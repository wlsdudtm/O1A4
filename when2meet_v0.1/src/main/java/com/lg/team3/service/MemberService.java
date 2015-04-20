package com.lg.team3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.MemberDao;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;
	
}
