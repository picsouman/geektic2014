package com.ninja_squad.geektic.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hobbie {
	
	// FIELDS
	@Id
	@Column(name = "IdKey")
	private long idKey;
	
	@Column(name = "Label")
	private String label;
	
	@Column(name = "Description")
	private String description;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "UserHobbies",
				joinColumns=@JoinColumn(name = "IdKeyHobbie", referencedColumnName = "IdKey"),
				inverseJoinColumns=@JoinColumn(name = "IdKeyUser", referencedColumnName = "IdKey"))
	private List<User> users;


	/**
	 * Default constructor
	 */
	public Hobbie()
	{
		
	}
	
	
	// AUTO-GENERATION
	public long getIdKey() {
		return idKey;
	}

	public void setIdKey(long _idKey) {
		this.idKey = _idKey;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String _label) {
		this.label = _label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String _description) {
		this.description = _description;
	}
	
	public List<User> getUsers() {
		return users;
	}
}
