package com.wachira.symptomserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.wachira.symptomserver.entities.Checkin;

@Repository
public interface CheckinRepository extends CrudRepository<Checkin, Integer> {

	public Checkin save(Checkin checkin);
}
