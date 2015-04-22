package com.lg.team3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.TestDao;

@Service
public class TestService {
	
	@Autowired
	TestDao dao;
	
	public int test(){
		return dao.test();
	}
}
