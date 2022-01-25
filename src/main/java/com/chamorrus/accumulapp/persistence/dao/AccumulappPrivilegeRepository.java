package com.chamorrus.accumulapp.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chamorrus.accumulapp.persistence.model.AccumulappPrivilege;

public interface AccumulappPrivilegeRepository extends JpaRepository<AccumulappPrivilege, Long> {

	AccumulappPrivilege findByName(String name);

	@Override
	void delete(AccumulappPrivilege role);

}