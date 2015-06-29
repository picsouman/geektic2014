package com.ninja_squad.geektic.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.models.Hobbie;
import com.ninja_squad.geektic.models.User;

@Repository
public class HobbieDAO {
	
	@PersistenceContext
	private EntityManager em = null;
	
	public HobbieDAO() {}
	
	public HobbieDAO(EntityManager em)
	{
		this.em = em;
	}
	
	/**
	 * Retourne tous les hobbies
	 * @return
	 */
	public List<Hobbie> findAll()
	{
		Query q = em.createQuery("SELECT h FROM Hobbie h");
		return q.getResultList();
	}
	
	/**
	 * Recherche par ID
	 * @param id
	 * @return
	 */
	public Hobbie findById(Long id)
	{
		return em.find(Hobbie.class, id);
	}
}
