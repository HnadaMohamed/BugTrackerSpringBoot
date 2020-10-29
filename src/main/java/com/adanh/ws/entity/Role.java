package com.adanh.ws.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="Role")
public class Role implements Serializable {

	private static final long serialVersionUID = 6294364649448687962L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	
	@Column(nullable = false ,unique = true)
	private String nameRole;

	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "role")
	private Set<UserApp> users = new HashSet<>(0);

	public Set<UserApp> getUsers() {
		return users;
	}

	public void setUsers(Set<UserApp> users) {
		this.users = users;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	
	
	
	
}
