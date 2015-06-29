package com.ninja_squad.geektic.models;

import com.ninja_squad.geektic.models.enums.UserSex;

public class UserFilter {
	
	// FIELDS
	private Hobbie hobbie;
	private UserSex sex;
	
	/**
	 * Constructor
	 */
	public UserFilter()
	{
		
	}

	
	
	// AUTO-GENERATED
	public Hobbie getHobbie() {
		return hobbie;
	}

	public void setHobbie(Hobbie hobbie) {
		this.hobbie = hobbie;
	}

	public UserSex getSex() {
		return sex;
	}

	public void setSex(UserSex sex) {
		this.sex = sex;
	}
}
