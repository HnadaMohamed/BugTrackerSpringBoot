package com.adanh.ws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Notification")
public class Notification implements Serializable {

	private static final long serialVersionUID = 4911863186686264244L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNotification;

	@Column(nullable = false)
	private String titleNotification;

	@Column(nullable = false)
	private String descNotification;

	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	public String getTitleNotification() {
		return titleNotification;
	}

	public void setTitleNotification(String titleNotification) {
		this.titleNotification = titleNotification;
	}

	public String getDescNotification() {
		return descNotification;
	}

	public void setDescNotification(String descNotification) {
		this.descNotification = descNotification;
	}

}
