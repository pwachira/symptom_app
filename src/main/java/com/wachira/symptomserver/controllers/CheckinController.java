package com.wachira.symptomserver.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wachira.symptomserver.entities.Checkin;
import com.wachira.symptomserver.entities.Medication;
import com.wachira.symptomserver.entities.MedicationHistory;
import com.wachira.symptomserver.entities.OkResponse;
import com.wachira.symptomserver.entities.Patient;
import com.wachira.symptomserver.repository.PatientRepository;
import com.wachira.symptomserver.service.CheckinDTO;
import com.wachira.symptomserver.service.CheckinService;
import com.wachira.symptomserver.service.MedicationHistoryDTO;
import com.wachira.symptomserver.service.PatientMedsDTO;

@Controller
public class CheckinController {
	@Autowired
	private CheckinService checkinService;
	
	@RequestMapping(value="/doctor/getPatients", method=RequestMethod.GET)
	public @ResponseBody List<Patient> getPatientsByDoctor(Principal principal){
		return checkinService.getPatientsByDoctor(principal.getName());
	}
	
	@RequestMapping("/authenticate")
	public @ResponseBody OkResponse EmptyMethod(){
		return new OkResponse("OK");
	}
	
	@RequestMapping(value = "/patient/getMedications",method=RequestMethod.GET)
	public @ResponseBody List<PatientMedsDTO> getPatientMeds(Principal principal){
		
		return checkinService.getPatientMeds( principal.getName());
	}
	
	@RequestMapping(value="/patient/checkin", method=RequestMethod.POST)
	public @ResponseBody OkResponse checkin(Principal principal,@RequestBody CheckinDTO checkinDTO){
		return checkinService.saveCheckinFromDTO(principal,checkinDTO);
	}
}
