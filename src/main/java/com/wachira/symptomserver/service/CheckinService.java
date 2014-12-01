package com.wachira.symptomserver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wachira.symptomserver.entities.Checkin;
import com.wachira.symptomserver.entities.Medication;
import com.wachira.symptomserver.entities.MedicationHistory;
import com.wachira.symptomserver.entities.Patient;
import com.wachira.symptomserver.entities.PatientMedication;
import com.wachira.symptomserver.repository.CheckinRepository;
import com.wachira.symptomserver.repository.MedicationHistoryRepository;
import com.wachira.symptomserver.repository.MedicationRepository;
import com.wachira.symptomserver.repository.PatientMedicationRepository;
import com.wachira.symptomserver.repository.PatientRepository;

 
@Service
public class CheckinService {
	@Autowired
	private PatientMedicationRepository pmRepo;

	@Autowired
	private MedicationRepository medRepo;
	
	@Autowired	
	private PatientRepository ptRepo;
	
	@Autowired
	private CheckinRepository checkinRepo;
	
	@Autowired
	private MedicationHistoryRepository medHxRepo;	
	
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
	
	public Patient findPatientByUserName(String username){
		return ptRepo.findByUserName(username);
	}
	
	public Medication findMedicationByMedicationName(String medicationName){
		return medRepo.findMedicationByMedicationName(medicationName);
	}
	
	public Checkin saveCheckin(Checkin checkin){
		return checkinRepo.save( checkin);
		
	}
	
	public Patient savePatient(Patient patient){
		return ptRepo.save( patient);
		
	}
	
	public MedicationHistory saveMedicationHistory(MedicationHistory medHx){
		return medHxRepo.save( medHx);
		
	}
}
