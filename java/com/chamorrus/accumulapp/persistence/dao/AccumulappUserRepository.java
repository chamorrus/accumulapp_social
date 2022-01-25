package com.chamorrus.accumulapp.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chamorrus.accumulapp.persistence.model.AccumulappUser;

@Repository
public interface AccumulappUserRepository extends CrudRepository<AccumulappUser, Long> {
	public AccumulappUser findByEmail(String email);
}
