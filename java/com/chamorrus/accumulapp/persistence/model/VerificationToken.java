package com.chamorrus.accumulapp.persistence.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "vrfctn_tkn")
public class VerificationToken {
	private static final int EXPIRATION = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="verification_token_sequence")
	@SequenceGenerator(name="verification_token_sequence", sequenceName="vrfctn_tkn_id_sq")
	private Long id;

	@OneToOne(targetEntity = AccumulappUser.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id_usr")
	private AccumulappUser user;

	@Column(name = "tkn")
	private String token;

	@Column(name = "crtn_tmstmp")
	private Timestamp creationTimestamp;

	@Column(name = "expry_dt")
	private Timestamp expiryDate;

	@Column(name = "actv")
	private boolean active;

	public VerificationToken() {
	}

	public VerificationToken(String token, AccumulappUser userEntity) {
		this.token = token;
		this.user = userEntity;
		this.expiryDate = new Timestamp(calculateExpiryDate(EXPIRATION).getTime());
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccumulappUser getUserEntity() {
		return user;
	}

	public void setUserEntity(AccumulappUser userEntity) {
		this.user = userEntity;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}