package com.adanh.ws.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="BugHistory")
public class BugHistory implements Serializable {

	private static final long serialVersionUID = 1847792854581835840L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBugHistory;
	
	@Column(nullable = false )
	private String propertyChanged;
	
	@Column(nullable = false )
	private Date date;
	
	@Column(nullable = false )
	private String oldValue;
	
	@Column(nullable = false )
	private String newValue;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idBug", insertable = false, updatable = false)
	private Bug bug;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser", insertable = false, updatable = false)
	private UserApp issuer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser", insertable = false, updatable = false)
	private UserApp developer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idProject", insertable = false, updatable = false)
	private Project project;

	
	public UserApp getIssuer() {
		return issuer;
	}

	public void setIssuer(UserApp issuer) {
		this.issuer = issuer;
	}

	public UserApp getDeveloper() {
		return developer;
	}

	public void setDeveloper(UserApp developer) {
		this.developer = developer;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public int getIdBugHistory() {
		return idBugHistory;
	}

	public void setIdBugHistory(int idBugHistory) {
		this.idBugHistory = idBugHistory;
	}

	public String getPropertyChanged() {
		return propertyChanged;
	}

	public void setPropertyChanged(String propertyChanged) {
		this.propertyChanged = propertyChanged;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	
	
}
