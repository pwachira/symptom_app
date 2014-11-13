package com.wachira.symptomserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckinController {
	
	@RequestMapping("/checkins/authenticate")
	public String EmptyMethod(){
		return "OK";
	}
	
}
