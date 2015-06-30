package com.ninja_squad.geektic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ninja_squad.geektic.dao.HobbieDAO;
import com.ninja_squad.geektic.dao.UserDAO;
import com.ninja_squad.geektic.models.Hobbie;
import com.ninja_squad.geektic.models.User;
import com.ninja_squad.geektic.models.UserFilter;
import com.ninja_squad.geektic.models.enums.UserSex;

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
	public User getUser(@PathVariable("id") long id, HttpServletRequest request)
	{
		String ipAddress = request.getRemoteAddr();
		userDAO.addUserVisit((long) id, ipAddress);
		return userDAO.findById(id);
	}
	
	@RequestMapping(value = "/hobbies", method = RequestMethod.GET)
	public List<Hobbie> getHobbies()
	{
		return hobbieDAO.findAll();
	}
	
	@RequestMapping(value = "/users/filter", method = RequestMethod.POST)
	public List<User> getFilteredUsers(@RequestBody UserFilter filter)
	{
		Hobbie h = hobbieDAO.findById(filter.getHobbie());
		if(h == null) return null;
		return h.getUsers().stream()
				.filter(u -> u.getUserSex() == filter.getSex())
				.collect(Collectors.toCollection(ArrayList::new));
	}
}