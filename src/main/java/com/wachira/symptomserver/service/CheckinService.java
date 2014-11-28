package com.wachira.symptomserver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wachira.symptomserver.entities.Patient;
import com.wachira.symptomserver.entities.PatientMedication;
import com.wachira.symptomserver.repository.PatientMedicationRepository;
import com.wachira.symptomserver.repository.PatientRepository;

 
@Service
public class CheckinService {
	@Autowired
	private PatientMedicationRepository pmRepo;
	
	@Autowired	
	private PatientRepository ptRepo;
	
	public List<PatientMedsDTO> getPatientMeds(String username){
		
		List<PatientMedsDTO> meds = new ArrayList<PatientMedsDTO>();
		Patient patient = ptRepo.findByUserName(username);
		List<PatientMedication> ptmeds = pmRepo.findByPatient(patient);
		for (PatientMedication ptmed : ptmeds){
			PatientMedsDTO ptmeddto = new PatientMedsDTO();
			ptmeddto.setMedicationId(ptmed.getMedication().getMedicationId());
			ptmeddto.setMedicationName(ptmed.getMedication().getMedicationName());
			ptmeddto.setPatientId(ptmed.getPatient().getPatientId());
			ptmeddto.setPatientUsername(ptmed.getPatient().getUserName());
			
			meds.add(ptmeddto);
		}
		return  meds;
	}
}
