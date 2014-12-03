package com.wachira.symptomserver.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.wachira.symptomserver.entities.Checkin;
import com.wachira.symptomserver.entities.Doctor;
import com.wachira.symptomserver.entities.Medication;
import com.wachira.symptomserver.entities.MedicationHistory;
import com.wachira.symptomserver.entities.OkResponse;
import com.wachira.symptomserver.entities.Patient;
import com.wachira.symptomserver.entities.PatientMedication;
import com.wachira.symptomserver.repository.CheckinRepository;
import com.wachira.symptomserver.repository.DoctorRepository;
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
	private DoctorRepository docRepo;
	
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
	
	@Transactional
	public OkResponse saveCheckinFromDTO(Principal principal,@RequestBody CheckinDTO checkinDTO){
		Checkin checkin = new Checkin();
		//checkin = checkinService.saveCheckin(checkin);
		checkin.setCheckindate(checkinDTO.getCheckindate());
		checkin.setEatingimpact(checkinDTO.getEatingimpact());
		checkin.setMedicationtaken(checkinDTO.getMedicationtaken());
		checkin.setPainseverity(checkinDTO.getPainseverity());
		
		
		Patient patient = findPatientByUserName(principal.getName());
		checkin.setPatient(patient);
		patient.addCheckin(checkin);
		
		List<MedicationHistory> listMedHx = new ArrayList<MedicationHistory>();
		
		for(MedicationHistoryDTO medHxDTO:checkinDTO.getMedicationHistories()){
			MedicationHistory medHx = new MedicationHistory();
			//medHx = checkinService.saveMedicationHistory(medHx);
			medHx.setCheckin(checkin);
			Medication med =
					findMedicationByMedicationName(medHxDTO.getMedication().getMedicationName());
			medHx.setMedication(med);
			med.addMedicationHistory(medHx);
			medHx.setPatient(patient);
			patient.addMedicationHistory(medHx);
			medHx.setTimeTaken(medHxDTO.getTimeTaken());
			listMedHx.add(medHx);
			saveMedicationHistory(medHx);
			//checkinService.saveMedication(med);
		}
		checkin.setMedicationHistories(listMedHx);
		saveCheckin(checkin);
		//checkinService.savePatient(patient);
		return new OkResponse("OK");
	
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

	public List<Patient> getPatientsByDoctor(String providerId) {
		Doctor doc = docRepo.findByNationalProviderId(providerId);
		return ptRepo.findByDoctor(doc);
	}

	public Medication saveMedication(Medication med) {
		return medRepo.save(med);
	}
}
