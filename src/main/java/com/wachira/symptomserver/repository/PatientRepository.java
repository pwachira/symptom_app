package com.wachira.symptomserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wachira.symptomserver.entities.Patient;

@RepositoryRestResource
public interface PatientRepository extends CrudRepository<Patient, Integer> {
	
	public List<Patient> findAll();
}
