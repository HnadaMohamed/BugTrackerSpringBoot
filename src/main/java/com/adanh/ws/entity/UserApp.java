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

@Entity(name="UserApp")
public class UserApp implements Serializable {
	
	private static final long serialVersionUID = -790305251259552231L;
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false )
	private String email;
	
	@Column(nullable = false )
	private String password;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idRol", insertable = false, updatable = false)
	private Role role;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "issuers") 
	private Set<Bug> issuerBugs = new HashSet<>(0);
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "developers")
	private Set<Bug> developerBugs = new HashSet<>(0);
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "developer")
	private Set<BugHistory> developerBugHistory = new HashSet<>(0);
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "issuer")
	private Set<BugHistory> issuerBugHistory = new HashSet<>(0);
	
	public Set<BugHistory> getDeveloperBugHistory() {
		return developerBugHistory;
	}
	public void setDeveloperBugHistory(Set<BugHistory> developerBugHistory) {
		this.developerBugHistory = developerBugHistory;
	}
	public Set<BugHistory> getIssuerBugHistory() {
		return issuerBugHistory;
	}
	public void setIssuerBugHistory(Set<BugHistory> issuerBugHistory) {
		this.issuerBugHistory = issuerBugHistory;
	}
	public Set<Bug> getIssuerBugs() {
		return issuerBugs;
	}
	public void setIssuerBugs(Set<Bug> issuerBugs) {
		this.issuerBugs = issuerBugs;
	}
	public Set<Bug> getDeveloperBugs() {
		return developerBugs;
	}
	public void setDeveloperBugs(Set<Bug> developerBugs) {
		this.developerBugs = developerBugs;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
	
	
	
}
