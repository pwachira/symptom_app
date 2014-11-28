package com.wachira.symptomserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.wachira.symptomserver.entities.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
	
	public List<Patient> findAll();
	
	public Patient findByUserName(String username);
}
