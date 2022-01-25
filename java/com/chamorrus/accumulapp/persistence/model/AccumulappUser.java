package com.chamorrus.accumulapp.persistence.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity(name = "a_usr")
public class AccumulappUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accumulapp_user_sequence")
	@SequenceGenerator(name = "accumulapp_user_sequence", sequenceName = "a_usr_id_sq")
	private Long id;

	@Column(name = "eml")
	private String email;

	@Column(name = "psswrd")
	private String password;

	@Transient
	private String passwordConfirm;

	@Column(name = "actv")
	private boolean active = false;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "a_usr_rl", joinColumns = @JoinColumn(name = "id_usr", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_rl", referencedColumnName = "id"))
	private Collection<AccumulappRole> roles;

	@Transient
	// @Column(name = "sign_in_provider", length = 20)
	private String signInProvider;

	public Collection<AccumulappRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<AccumulappRole> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getId() {
		return this.id;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public boolean isActive() {
		return this.active;
	}

	public String getSignInProvider() {
		return signInProvider;
	}
}