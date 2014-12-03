package com.wachira.symptomserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.wachira.symptomserver.entities.Medication;

@Repository
public interface MedicationRepository extends
		CrudRepository<Medication, Integer> {
	public Medication findMedicationByMedicationName(String medicationName);
	public Medication save(Medication med);
}
