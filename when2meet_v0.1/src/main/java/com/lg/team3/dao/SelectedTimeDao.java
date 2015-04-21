package com.lg.team3.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lg.team3.model.MemberModel;
import com.lg.team3.model.SelectedTimeModel;

public class SelectedTimeDao extends SqlSessionDaoSupport {
	private final String namespace = "com.lg.team3.selectedTime.";

	public boolean addSelectedTime(SelectedTimeModel selectedTimeModel) {
		int result = getSqlSession().insert(namespace + "addSelectedTime",
				selectedTimeModel);
		return (result != 0) ? (true) : (false);
	}
}
