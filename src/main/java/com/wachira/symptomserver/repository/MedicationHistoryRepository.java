package com.wachira.symptomserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wachira.symptomserver.entities.MedicationHistory;

@RepositoryRestResource
public interface MedicationHistoryRepository extends
		CrudRepository<MedicationHistory, Integer> {

}
