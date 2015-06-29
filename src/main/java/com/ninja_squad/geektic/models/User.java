package com.ninja_squad.geektic.models;

import java.util.List;

import javax.persistence.*;

import com.ninja_squad.geektic.models.enums.UserGroup;
import com.ninja_squad.geektic.models.enums.UserSex;
import com.ninja_squad.geektic.models.enums.UserState;

@Entity
public class User {
	
	// FIELDS
	@Id
	@Column(name = "IdKey")
	private long _idKey;
	
	@Column(name = "UserName")
	private String _userName;
	
	@Column(name = "UserEmail")
	private String _userEmail;
	
	@Column(name = "UserState")
	@Enumerated(EnumType.STRING)
	private UserState _userState;
	
	@Column(name = "UserGroup")
	@Enumerated(EnumType.STRING)
	private UserGroup _userGroup;
	
	@Column(name = "UserSex")
	@Enumerated(EnumType.STRING)
	private UserSex _userSex;
	
	@Column(name = "UserAge")
	private int _userAge;
	
	@Column(name = "UserShowEmail")
	private boolean _userShowEmail;

	@ManyToMany
	private List<Hobbie> _userHobbies;



	/**
	 * Default Constructor
	 */
	public User()
	{
		
	}
	
	
	// AUTO-GENERATION
	public long getIdKey() {
		return _idKey;
	}

	public void setIdKey(long _idKey) {
		this._idKey = _idKey;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String _userName) {
		this._userName = _userName;
	}

	public String getUserEmail() {
		return getUserShowEmail() ? _userEmail : ".....";
	}

	public void setUserEmail(String _userEmail) {
		this._userEmail = _userEmail;
	}

	public UserState getUserState() {
		return _userState;
	}

	public void setUserState(UserState _userState) {
		this._userState = _userState;
	}

	public UserGroup getUserGroup() {
		return _userGroup;
	}

	public void setUserGroup(UserGroup _userGroup) {
		this._userGroup = _userGroup;
	}

	public UserSex getUserSex() {
		return _userSex;
	}

	public void setUserSex(UserSex _userSex) {
		this._userSex = _userSex;
	}

	public int getUserAge() {
		return _userAge;
	}

	public void setUserAge(int _userAge) {
		this._userAge = _userAge;
	}
	public boolean getUserShowEmail() {
		return _userShowEmail;
	}

	public void setUserShowEmail(boolean _userShowEmail) {
		this._userShowEmail = _userShowEmail;
	}
	
	public List<Hobbie> getUserHobbies() {
		return _userHobbies;
	}

	public void setUserHobbies(List<Hobbie> _userHobbies) {
		this._userHobbies = _userHobbies;
	}
}
