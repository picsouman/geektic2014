package com.ninja_squad.geektic.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Hobbie {
	
	// FIELDS
	@Id
	@Column(name = "IdKey")
	private long _idKey;
	
	@Column(name = "Label")
	private String _label;
	
	@Column(name = "Description")
	private String _description;
	
	@ManyToMany
	@JoinTable(name = "UserHobbies",
				joinColumns=@JoinColumn(name = "IdKeyHobbie", referencedColumnName = "IdKey"),
				inverseJoinColumns=@JoinColumn(name = "IdKeyUser", referencedColumnName = "IdKey"))
	private List<User> _users;


	/**
	 * Default constructor
	 */
	public Hobbie()
	{
		_users = new ArrayList<User>();
	}
	
	
	// AUTO-GENERATION
	public long getIdKey() {
		return _idKey;
	}

	public void setIdKey(long _idKey) {
		this._idKey = _idKey;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String _label) {
		this._label = _label;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String _description) {
		this._description = _description;
	}
	
	public List<User> getUsers() {
		return _users;
	}
}
