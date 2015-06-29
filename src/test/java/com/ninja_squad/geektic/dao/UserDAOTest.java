package com.ninja_squad.geektic.dao;

import java.util.List;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.models.User;
import com.ninja_squad.geektic.models.enums.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;


public class UserDAOTest extends BaseDaoTest {

    private UserDAO dao;

    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(); // TODO define your operations here.
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
        dao = new UserDAO(em);
    }

    @Test
    public void findAll() {
        List<User> list = dao.findAll();
        Assert.notNull(list);
        Assert.isTrue(list.size() == 6);
    }
    
    @Test
    public void findbyId() {
        User u = dao.findById((long) 0);
        Assert.notNull(u);
        Assert.isTrue(u.getUserName().equalsIgnoreCase("aimeric"));
    }
    
    @Test
    public void findbyName() {
        List<User> list = dao.findByName("er");
        Assert.notNull(list);
        Assert.isTrue(list.size() == 2);
    }
}
