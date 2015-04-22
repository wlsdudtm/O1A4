package com.lg.team3.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.PartyMemberModel;
import com.lg.team3.model.SelectedTimeModel;
import com.lg.team3.model.TimeInfoModel;

public class SelectedTimeDao extends SqlSessionDaoSupport {
	private final String namespace = "com.lg.team3.selectedTime.";

	public boolean addSelectedTime(SelectedTimeModel selectedTimeModel) {
		int result = getSqlSession().insert(namespace + "addSelectedTime",
				selectedTimeModel);
		return (result != 0) ? (true) : (false);
	}
	
	public List<TimeInfoModel> getSelectedTime(int partyId){
		return getSqlSession().selectList(namespace+"getSelectedTime", partyId);
	}
}
