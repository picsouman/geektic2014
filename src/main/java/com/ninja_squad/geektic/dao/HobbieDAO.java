package com.ninja_squad.geektic.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ninja_squad.geektic.models.Hobbie;
import com.ninja_squad.geektic.models.User;

public class HobbieDAO {
	
	private EntityManager _em = null;
	
	public HobbieDAO(EntityManager em)
	{
		_em = em;
	}
	
	/**
	 * Retourne tous les hobbies
	 * @return
	 */
	public List<Hobbie> findAll()
	{
		try
		{
			Query q = _em.createQuery("SELECT h FROM Hobbie h");
			return q.getResultList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ArrayList<Hobbie>();
		}
	}
	
	/**
	 * Recherche par ID
	 * @param id
	 * @return
	 */
	public Hobbie findById(Long id)
	{
		try
		{
			return _em.find(Hobbie.class, id);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}
