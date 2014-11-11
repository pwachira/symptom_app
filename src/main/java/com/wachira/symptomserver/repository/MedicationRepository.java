package com.wachira.symptomserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wachira.symptomserver.entities.Medication;

@RepositoryRestResource
public interface MedicationRepository extends
		CrudRepository<Medication, Integer> {

}
