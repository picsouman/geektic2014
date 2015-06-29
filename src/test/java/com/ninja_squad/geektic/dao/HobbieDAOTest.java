package com.ninja_squad.geektic.dao;

import java.util.List;
import java.util.Set;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.models.Hobbie;
import com.ninja_squad.geektic.models.User;
import com.ninja_squad.geektic.models.enums.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


public class HobbieDAOTest extends BaseDaoTest {

    private HobbieDAO dao;

    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(); // TODO define your operations here.
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
        dao = new HobbieDAO(em);
    }

    @Test
    public void findAll() {
        List<Hobbie> list = dao.findAll();
        Assert.notNull(list);
        Assert.isTrue(list.size() == 8);
    }
    
    @Test
    public void findbyId() {
        Hobbie u = dao.findById((long) 0);
        Assert.notNull(u);
        Assert.isTrue(u.getLabel().equalsIgnoreCase("pétanque"));
    }
    
    @Test
    @Transactional
    public void testUserHobbies()
    {
    	Hobbie u = dao.findById((long) 0);
    	List<User> list = u.getUsers();
    	Assert.isTrue(list.size() == 1);
    }
}
