package com.chamorrus.accumulapp.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "a_rl_prvlg")
public class AccumulappRolePrivilege implements Serializable {
	private static final long serialVersionUID = 2608153149331609043L;

	@Id
	@Column(name = "id_rl")
	private Long idRole;

	@Id
	@Column(name = "id_prvlg")
	private Long idPrivilege;

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public Long getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(Long idPrivilege) {
		this.idPrivilege = idPrivilege;
	}

}
