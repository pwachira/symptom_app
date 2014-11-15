package com.wachira.symptomserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckinController {
	
	@RequestMapping("/authenticate")
	public @ResponseBody String EmptyMethod(){
		return "{Successfull authentication}";
	}
	
}
