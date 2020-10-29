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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="Bug")
public class Bug implements Serializable{

	private static final long serialVersionUID = -2099781254626363165L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBug;
	
	@Column(nullable = false)
	private String titleBug;
	
	@Column(nullable = false)
	private String descBug;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idProject", insertable = false, updatable = false)
	private Project project;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPriority", insertable = false, updatable = false)
	private Priority priority;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idBugType", insertable = false, updatable = false)
	private BugType bugType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idState", insertable = false, updatable = false)
	private State state;
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "bug")
	private Set<Document> documents = new HashSet<>(0);
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "bug")
	private Set<Comment> comments = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "bug")
	private Set<BugHistory> BugHistoryies = new HashSet<>(0);
	
	@ManyToMany(fetch = FetchType.LAZY )
	private Set<UserApp> developers = new HashSet<>(0);
	
	@ManyToMany(fetch = FetchType.LAZY )
	private Set<UserApp> issuers = new HashSet<>(0);
	
	public Set<UserApp> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Set<UserApp> developers) {
		this.developers = developers;
	}

	public Set<UserApp> getIssuers() {
		return issuers;
	}

	public void setIssuers(Set<UserApp> issuers) {
		this.issuers = issuers;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<BugHistory> getBugHistoryies() {
		return BugHistoryies;
	}

	public void setBugHistoryies(Set<BugHistory> bugHistoryies) {
		BugHistoryies = bugHistoryies;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public BugType getBugType() {
		return bugType;
	}

	public void setBugType(BugType bugType) {
		this.bugType = bugType;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getIdBug() {
		return idBug;
	}

	public void setIdBug(int idBug) {
		this.idBug = idBug;
	}

	public String getTitleBug() {
		return titleBug;
	}

	public void setTitleBug(String titleBug) {
		this.titleBug = titleBug;
	}

	public String getDescBug() {
		return descBug;
	}

	public void setDescBug(String descBug) {
		this.descBug = descBug;
	}
	
}
