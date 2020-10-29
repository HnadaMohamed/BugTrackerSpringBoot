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

@Entity(name="Project")
public class Project implements Serializable {

	private static final long serialVersionUID = -3226498765899044172L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProject;
	
	@Column(nullable = false ,unique = true)
	private String nameProject;
	
	@Column(nullable = true)
	private String descProject;
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "project" )
	private Set<Bug> bugs = new HashSet<>(0);
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "project")
	private Set<BugHistory> BugHistoryies = new HashSet<>(0);	
	
	public Set<BugHistory> getBugHistoryies() {
		return BugHistoryies;
	}

	public void setBugHistoryies(Set<BugHistory> bugHistoryies) {
		BugHistoryies = bugHistoryies;
	}

	public Set<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(Set<Bug> bugs) {
		this.bugs = bugs;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public String getDescProject() {
		return descProject;
	}

	public void setDescProject(String descProject) {
		this.descProject = descProject;
	}

	

	

}
