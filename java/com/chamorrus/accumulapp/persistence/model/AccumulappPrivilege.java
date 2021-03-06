package com.chamorrus.accumulapp.persistence.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "a_prvlg")
public class AccumulappPrivilege {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nm")
	private String name;

	@Column(name = "dscrptn")
	private String description;

	@Column(name = "actv")
	private boolean active;

	@ManyToMany(mappedBy = "privileges")
	private Collection<AccumulappRole> roles;

	public AccumulappPrivilege() {
		super();
	}

	public AccumulappPrivilege(final String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
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

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Collection<AccumulappRole> getRoles() {
		return roles;
	}

	public void setRoles(final Collection<AccumulappRole> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccumulappPrivilege other = (AccumulappPrivilege) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Privilege [name=").append(name).append("]").append("[id=").append(id).append("]");
		return builder.toString();
	}
}