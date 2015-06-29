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
			return "D�sactiv�";
		case ENABLE:
			return "Activ�";
		case WAITINGFORVALIDATION:
			return "Attente de validation";
		default:
			return "N/A";
		}
	}
}
