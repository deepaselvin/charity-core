package com.revature.charity.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.charity.dao.UserDAO;
import com.revature.charity.dao.UserImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.model.User;
import com.revature.charity.util.Logger;

public class UserLoginTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void validLoginTest()
	{
		UserDAO userDAO = new UserImpl();
		User user = new User();
		User userObj = new User();
		user.setName("deepa");
		user.setEmail("deepa@gmaii.com");
		user.setPhone(9488544846l);
		try {
			userObj = userDAO.donorLogin(user);
			assertNotNull(userObj);
		} catch (DBException e) {
			Logger.debug(e.getMessage());
		}
	}
	
	@Test
	public void invalidLoginTest()
	{
		UserDAO userDAO = new UserImpl();
		User user = new User();
		User userObj = new User();
		user.setName("ee");
		user.setEmail("ee@gmaii.com");
		user.setPhone(90102100214l);
		try {
			userObj = userDAO.donorLogin(user);
			assertNotNull(userObj);
		} catch (DBException e) {
			Logger.debug(e.getMessage());
		}
	}

	
}
