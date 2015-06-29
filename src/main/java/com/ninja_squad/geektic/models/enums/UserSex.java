package com.ninja_squad.geektic.models.enums;

public enum UserSex {
	MALE,
	FEMALE;
	
	@Override
	public String toString()
	{
		switch(this)
		{
		case FEMALE:
			return "Femme";
		case MALE:
			return "Homme";
		default:
			return "N/A";
		}
	}
}
