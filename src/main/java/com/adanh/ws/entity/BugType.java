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

@Entity(name="BugType")
public class BugType implements Serializable {

	private static final long serialVersionUID = -3136150865042010110L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBugType;
	
	@Column(nullable = false ,unique = true)
	private String titleBugType;
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "bugType")
	private Set<Bug> bugs = new HashSet<>(0);

	public int getIdBugType() {
		return idBugType;
	}

	public void setIdBugType(int idBugType) {
		this.idBugType = idBugType;
	}

	public String getTitleBugType() {
		return titleBugType;
	}

	public void setTitleBugType(String titleBugType) {
		this.titleBugType = titleBugType;
	}

	public Set<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(Set<Bug> bugs) {
		this.bugs = bugs;
	}


	
}
