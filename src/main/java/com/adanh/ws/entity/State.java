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

@Entity(name="State")
public class State implements Serializable {

	
	private static final long serialVersionUID = -8590931528445394065L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idState;
	
	@Column(nullable = false ,unique = true)
	private String titleState;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	private Set<Bug> bugs = new HashSet<>(0);
	
	public int getIdState() {
		return idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}

	public String getTitleState() {
		return titleState;
	}

	public void setTitleState(String titleState) {
		this.titleState = titleState;
	}

	public Set<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(Set<Bug> bugs) {
		this.bugs = bugs;
	}

	
	
	
	
}
