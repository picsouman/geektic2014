package com.ninja_squad.geektic.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ninja_squad.geektic.models.enums.UserGroup;
import com.ninja_squad.geektic.models.enums.UserSex;
import com.ninja_squad.geektic.models.enums.UserState;

@Entity
public class User {
	
	// FIELDS
	@Id
	@Column(name = "IdKey")
	private long idKey;
	
	@Column(name = "UserName")
	private String userName;
	
	@Column(name = "UserEmail")
	private String userEmail;
	
	@Column(name = "UserState")
	@Enumerated(EnumType.STRING)
	private UserState userState;
	
	@Column(name = "UserGroup")
	@Enumerated(EnumType.STRING)
	private UserGroup userGroup;
	
	@Column(name = "UserSex")
	@Enumerated(EnumType.STRING)
	private UserSex userSex;
	
	@Column(name = "UserAge")
	private int userAge;
	
	@Column(name = "UserShowEmail")
	private boolean userShowEmail;

	@ManyToMany
	@JoinTable(name = "UserHobbies",
				joinColumns=@JoinColumn(name = "IdKeyUser"),
				inverseJoinColumns=@JoinColumn(name = "IdKeyHobbie"))
	private List<Hobbie> userHobbies;



	/**
	 * Default Constructor
	 */
	public User()
	{
		
	}
	
	
	// AUTO-GENERATION
	public long getIdKey() {
		return idKey;
	}

	public void setIdKey(long _idKey) {
		this.idKey = _idKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String _userName) {
		this.userName = _userName;
	}

	public String getUserEmail() {
		return getUserShowEmail() ? userEmail : ".....";
	}

	public void setUserEmail(String _userEmail) {
		this.userEmail = _userEmail;
	}

	public UserState getUserState() {
		return userState;
	}

	public void setUserState(UserState _userState) {
		this.userState = _userState;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup _userGroup) {
		this.userGroup = _userGroup;
	}

	public UserSex getUserSex() {
		return userSex;
	}

	public void setUserSex(UserSex _userSex) {
		this.userSex = _userSex;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int _userAge) {
		this.userAge = _userAge;
	}
	public boolean getUserShowEmail() {
		return userShowEmail;
	}

	public void setUserShowEmail(boolean _userShowEmail) {
		this.userShowEmail = _userShowEmail;
	}
	
	public List<Hobbie> getUserHobbies() {
		return userHobbies;
	}
}
