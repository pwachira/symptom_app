package com.wachira.symptomserver.controllers;

import java.security.Principal;
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
		
		Checkin checkin = new Checkin();
		checkin.setCheckindate(checkinDTO.getCheckindate());
		checkin.setEatingimpact(checkinDTO.getEatingimpact());
		checkin.setMedicationtaken(checkinDTO.getMedicationtaken());
		checkin.setPainseverity(checkinDTO.getPainseverity());
		
		
		Patient patient = checkinService.findPatientByUserName(principal.getName());
		checkin.setPatient(patient);
		patient.addCheckin(checkin);
		
		
		
		for(MedicationHistoryDTO medHxDTO:checkinDTO.getMedicationHistories()){
			MedicationHistory medHx = new MedicationHistory();
			medHx.setCheckin(checkin);
			Medication med =checkinService
			.findMedicationByMedicationName(medHxDTO.getMedication().getMedicationName());
			medHx.setMedication(med);
			med.addMedicationHistory(medHx);
			medHx.setPatient(patient);
			patient.addMedicationHistory(medHx);
			medHx.setTimeTaken(medHxDTO.getTimeTaken());
			checkinService.saveMedicationHistory(medHx);
		}
	
		checkinService.saveCheckin(checkin);
		checkinService.savePatient(patient);
		return new OkResponse("OK");
	}
}
