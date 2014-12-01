package com.wachira.symptomserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.wachira.symptomserver.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

	public Doctor findByNationalProviderId(String providerId);
}
