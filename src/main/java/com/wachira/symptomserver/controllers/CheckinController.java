package com.wachira.symptomserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wachira.symptomserver.entities.OkResponse;

@Controller
public class CheckinController {
	
	@RequestMapping("/authenticate")
	public @ResponseBody OkResponse EmptyMethod(){
		return new OkResponse("OK");
	}
	
}
