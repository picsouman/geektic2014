package com.ninja_squad.geektic.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.models.Hobbie;
import com.ninja_squad.geektic.models.User;
import com.ninja_squad.geektic.models.UserFilter;

@Repository
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public UserDAO() {}
	
	/**
	 * Constructor
	 * @param em
	 */
	public UserDAO(EntityManager em)
	{
		this.em = em;
	}
	
	/**
	 * Retourne tous les utilisateurs
	 * @return
	 */
	public List<User> findAll()
	{
		Query q = em.createQuery("SELECT u FROM User u");
		return q.getResultList();
	}
	
	/**
	 * Recherche par ID
	 * @param id
	 * @return
	 */
	public User findById(Long id)
	{
		return em.find(User.class, id);
	}
	
	/**
	 * Recherche par nom
	 * @param name
	 * @return
	 */
	public List<User> findByName(String name)
	{
		Query q = em.createQuery("SELECT u FROM User u WHERE Lower(UserName) LIKE :name");
		q.setParameter("name", "%" + name.toLowerCase() + "%");
		return q.getResultList();
	}
	
	public List<User> findByHobbies(Hobbie h)
	{
		List<Hobbie> list = new ArrayList<Hobbie>();
		list.add(h);
		return findByHobbies(list);
	}
	
	public List<User> findByHobbies(List<Hobbie> list)
	{
		List<User> data = new ArrayList<User>();
		for(Hobbie h : list)
			for(User u : h.getUsers())
				if(data.stream().allMatch(e -> e.getIdKey() != u.getIdKey()))
					data.add(u);
		return data;
	}
	
	public void addUserVisit(long user, String ipAddress)
	{
		if(ipAddress == null) return;
		if(ipAddress.length() > 40) return;
		Query q = em.createQuery("INSERT INTO UserVisit(IdKeyUser, GuestIP) values (:id, :ip);");
		q.setParameter("id", user);
		q.setParameter("ip", ipAddress);
		q.executeUpdate();
	}
}
