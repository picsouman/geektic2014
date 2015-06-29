package com.ninja_squad.geektic.models.enums;

public enum UserState {
	DISABLE,
	ENABLE,
	WAITINGFORVALIDATION;
	
	@Override
	public String toString()
	{
		switch(this)
		{
		case DISABLE:
			return "Désactivé";
		case ENABLE:
			return "Activé";
		case WAITINGFORVALIDATION:
			return "Attente de validation";
		default:
			return "N/A";
		}
	}
}
