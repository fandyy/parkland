package com.fandy.dao;


import com.fandy.domain.User;
import com.fandy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void hasMatchUser() {
        int count  = userDao.getMatchCount("admin", "123456");
        assertTrue(count>0);
    }

    @Test
    public void findUserByUserName() {
        User user = userDao.findUserByUserName("admin");
        assertNotNull(user);
        assertEquals(user.getUserName(), "admin");
    }

}
