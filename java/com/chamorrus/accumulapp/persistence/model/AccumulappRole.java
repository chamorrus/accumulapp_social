package com.chamorrus.accumulapp.persistence.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "a_rl")
public class AccumulappRole {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="accumulapp_role_sequence")
	@SequenceGenerator(name="accumulapp_role_sequence", sequenceName="a_rl_id_sq")
	private Long id;

	@Column(name = "nm")
	private String name;

	@Column(name = "dscrptn")
	private String description;

	@Column(name = "actv")
	private boolean active;

	@ManyToMany(mappedBy = "roles")
	private Collection<AccumulappUser> users;

	@ManyToMany
	@JoinTable(name = "a_rl_prvlg", joinColumns = @JoinColumn(name = "id_rl", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_prvlg", referencedColumnName = "id"))
	private Collection<AccumulappPrivilege> privileges;

	public AccumulappRole() {
		super();
	}

	public AccumulappRole(final String name) {
		super();
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Collection<AccumulappUser> getUsers() {
		return users;
	}

	public void setUsers(final Collection<AccumulappUser> users) {
		this.users = users;
	}

	public Collection<AccumulappPrivilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(final Collection<AccumulappPrivilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AccumulappRole role = (AccumulappRole) obj;
		if (!role.equals(role.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Role [name=").append(name).append("]").append("[id=").append(id).append("]");
		return builder.toString();
	}
}