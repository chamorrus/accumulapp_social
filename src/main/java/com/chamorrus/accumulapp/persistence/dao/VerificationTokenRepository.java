package com.chamorrus.accumulapp.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chamorrus.accumulapp.persistence.model.AccumulappUser;
import com.chamorrus.accumulapp.persistence.model.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
	public VerificationToken findByToken(String token);

	public VerificationToken findByUser(AccumulappUser user);
}