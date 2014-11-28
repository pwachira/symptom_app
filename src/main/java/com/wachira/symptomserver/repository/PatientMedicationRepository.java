package com.wachira.symptomserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.wachira.symptomserver.entities.MedicationHistory;
import com.wachira.symptomserver.entities.Patient;
import com.wachira.symptomserver.entities.PatientMedication;

@Repository
public interface PatientMedicationRepository extends
		CrudRepository<PatientMedication, Integer> {
	public List<PatientMedication> findByPatient(Patient patient);
}
