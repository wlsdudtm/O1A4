package com.lg.team3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.SelectedTimeDao;
import com.lg.team3.model.SelectedTimeModel;
import com.lg.team3.model.TimeInfoModel;

@Service
public class SelectedTimeService {
	@Autowired
	SelectedTimeDao selectedTimeDao;
	
	public boolean addSelectedTime(SelectedTimeModel selectedTimeModel) {
		
		boolean result = selectedTimeDao.addSelectedTime(selectedTimeModel);
		return result;
	}
	
	// partyId와 memberId를 받아서 
	public List<TimeInfoModel> getSelectedTime(int partyId){
		return selectedTimeDao.getSelectedTime(partyId);
	}
}
