package com.wachira.symptomserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wachira.symptomserver.entities.Checkin;

@RepositoryRestResource
public interface CheckinRepository extends CrudRepository<Checkin, Integer> {

}
