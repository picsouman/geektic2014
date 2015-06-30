package com.ninja_squad.geektic.models;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class UserVisit {

	// FIELDS
	@Id
	@Column(name = "IdKey")
	private long idKey;
	@Column(name = "GuestIP")
	private String guestIP;
	@Column(name = "Date")
	private Date date;
	

	public UserVisit()
	{
		
	}
	
	
	// AUTO-GENERATED
	public long getIdKey() {
		return idKey;
	}

	public void setIdKey(long idKey) {
		this.idKey = idKey;
	}

	public String getGuestIP() {
		return guestIP;
	}

	public void setGuestIP(String guestIP) {
		this.guestIP = guestIP;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
