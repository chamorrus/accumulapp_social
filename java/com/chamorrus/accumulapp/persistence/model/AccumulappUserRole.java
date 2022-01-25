package com.chamorrus.accumulapp.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "a_usr_rl")
public class AccumulappUserRole implements Serializable {
	private static final long serialVersionUID = -1543690238942956498L;

	@Id
	@Column(name = "id_usr")
	private Long idUser;

	@Id
	@Column(name = "id_rl")
	private Long idRole;

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
}
