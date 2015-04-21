package com.lg.team3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.SelectedTimeDao;
import com.lg.team3.model.SelectedTimeModel;

@Service
public class SelectedTimeService {
	@Autowired
	SelectedTimeDao selectedTimeDao;

	public boolean addSelectedTime(SelectedTimeModel selectedTimeModel) {
		
		boolean result = selectedTimeDao.addSelectedTime(selectedTimeModel);
		return result;
	}
}
