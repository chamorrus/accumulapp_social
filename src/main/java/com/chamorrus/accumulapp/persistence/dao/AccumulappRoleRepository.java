package com.chamorrus.accumulapp.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chamorrus.accumulapp.persistence.model.AccumulappRole;

public interface AccumulappRoleRepository extends JpaRepository<AccumulappRole, Long> {

	AccumulappRole findByName(String name);

	@Override
	void delete(AccumulappRole role);

}