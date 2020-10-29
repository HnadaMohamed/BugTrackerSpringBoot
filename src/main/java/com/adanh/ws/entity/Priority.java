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

@Entity(name="Priority")
public class Priority implements Serializable{

	private static final long serialVersionUID = -2458186443287520598L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPriority;
	
	@Column(nullable = false ,unique = true)
	private String titlePriority;
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "priority")
	private Set<Bug> bugs = new HashSet<>(0);

	public int getIdPriority() {
		return idPriority;
	}

	public void setIdPriority(int idPriority) {
		this.idPriority = idPriority;
	}

	public String geTtitlePriority() {
		return titlePriority;
	}

	public void setTitlePriority(String titlePriority) {
		this.titlePriority = titlePriority;
	}


	public String getTitlePriority() {
		return titlePriority;
	}

	public Set<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(Set<Bug> bugs) {
		this.bugs = bugs;
	}
	
	
	
}
