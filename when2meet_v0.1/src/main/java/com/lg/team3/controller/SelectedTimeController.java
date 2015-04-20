package com.lg.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lg.team3.service.SelectedTimeService;

@Controller
public class SelectedTimeController {
	@Autowired
	SelectedTimeService selectedTimeService;
}
