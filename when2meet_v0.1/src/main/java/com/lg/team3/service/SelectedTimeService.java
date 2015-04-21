package com.lg.team3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.SelectedTimeDao;

@Service
public class SelectedTimeService {
	@Autowired
	SelectedTimeDao selectedTimeDao;

	public boolean addSelectedTime() {
		
		return false;
	}
}
