package com.adanh.ws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 5828090340136878617L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComment;

	@Column(nullable = false)
	private String descComment;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idBug", insertable = false, updatable = false)
	private Bug bug;
	
	
	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public String getDescComment() {
		return descComment;
	}

	public void setDescComment(String descComment) {
		this.descComment = descComment;
	}

	
	
	
}
