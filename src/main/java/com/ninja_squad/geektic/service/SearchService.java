package com.ninja_squad.geektic.service;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.ninja_squad.geektic.dao.HobbieDAO;
import com.ninja_squad.geektic.dao.UserDAO;
import com.ninja_squad.geektic.models.Hobbie;
import com.ninja_squad.geektic.models.User;

@RestController
@Transactional
@RequestMapping("/api/search")
public class SearchService {
	
	private UserDAO userDAO;
	private HobbieDAO hobbieDAO;
	
	@Autowired
	public SearchService(UserDAO dao, HobbieDAO dao2)
	{
		userDAO = dao;
		hobbieDAO = dao2;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUserList()
	{
		return userDAO.findAll();
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") long id)
	{
		return userDAO.findById(id);
	}
	
	@RequestMapping(value = "/hobbies", method = RequestMethod.GET)
	public List<Hobbie> getHobbies()
	{
		return hobbieDAO.findAll();
	}
}