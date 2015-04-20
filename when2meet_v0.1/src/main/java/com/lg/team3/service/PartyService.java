package com.lg.team3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.team3.dao.PartyDao;

@Service
public class PartyService {

	@Autowired
	PartyDao partyDao;
}
