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

@Entity(name="Document")
public class Document implements Serializable {

	private static final long serialVersionUID = -4833079983277054940L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocument;
	
	@Column(nullable = false)
	private byte[] document;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idBug", insertable = false, updatable = false)
	private Bug bug;
	

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public int getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	
}
