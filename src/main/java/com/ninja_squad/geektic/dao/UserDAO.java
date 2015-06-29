package com.ninja_squad.geektic.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ninja_squad.geektic.models.Hobbie;
import com.ninja_squad.geektic.models.User;

public class UserDAO {
	
	private EntityManager _em = null;
	
	/**
	 * Constructor
	 * @param em
	 */
	public UserDAO(EntityManager em)
	{
		_em = em;
	}
	
	/**
	 * Retourne tous les utilisateurs
	 * @return
	 */
	public List<User> findAll()
	{
		try
		{
			Query q = _em.createQuery("SELECT u FROM User u");
			return q.getResultList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ArrayList<User>();
		}
	}
	
	/**
	 * Recherche par ID
	 * @param id
	 * @return
	 */
	public User findById(Long id)
	{
		try
		{
			return _em.find(User.class, id);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Recherche par nom
	 * @param name
	 * @return
	 */
	public List<User> findByName(String name)
	{
		try
		{
			Query q = _em.createQuery("SELECT u FROM User u WHERE Lower(UserName) LIKE :name");
			q.setParameter("name", "%" + name.toLowerCase() + "%");
			return q.getResultList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ArrayList<User>();
		}
	}
	
	public List<User> findByHobbies(Hobbie h)
	{
		List<Hobbie> list = new ArrayList<Hobbie>();
		list.add(h);
		return findByHobbies(list);
	}
	
	public List<User> findByHobbies(List<Hobbie> list)
	{
		try
		{
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ArrayList<User>();
		}
	}
}
