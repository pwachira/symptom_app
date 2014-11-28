package com.wachira.symptomserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.wachira.symptomserver.entities.MedicationHistory;

@Repository
public interface MedicationHistoryRepository extends
		CrudRepository<MedicationHistory, Integer> {

}
