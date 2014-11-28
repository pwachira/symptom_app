package com.wachira.symptomserver.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wachira.symptomserver.entities.OkResponse;
import com.wachira.symptomserver.service.CheckinService;
import com.wachira.symptomserver.service.PatientMedsDTO;

@Controller
public class CheckinController {
	@Autowired
	private CheckinService checkinService;
	
	@RequestMapping("/authenticate")
	public @ResponseBody OkResponse EmptyMethod(){
		return new OkResponse("OK");
	}
	
	@RequestMapping(value = "/patientMedications",method=RequestMethod.GET)
	public @ResponseBody List<PatientMedsDTO> getPatientMeds(Principal principal){
		
		return checkinService.getPatientMeds( principal.getName());
	}
	
}
