package com.ninja_squad.geektic.models;

import javax.persistence.*;

@Entity
public class Hobbie {
	
	// FIELDS
	@Id
	private long _idKey;
	
	@Column(name = "Label")
	private String _label;
	
	@Column(name = "Description")
	private String _description;
	
	/**
	 * Default constructor
	 */
	public Hobbie()
	{
		
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
}
