package com.ninja_squad.geektic.dao;

import javax.persistence.EntityManager;

public class HobbieDAO {
	
	private EntityManager _em = null;
	
	public HobbieDAO(EntityManager em)
	{
		_em = em;
	}
}
