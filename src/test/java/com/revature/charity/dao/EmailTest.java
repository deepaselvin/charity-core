package com.revature.charity.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.charity.dao.UserDAO;
import com.revature.charity.dao.UserImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.model.User;

public class EmailTest {


	@Test
	public void validEmailExist()
	{
		  
		 UserDAO user = new UserImpl();
		 User userObj = new User();
		try {
			userObj = user.isEmailExist("test@gmail.com");
			assertNotNull(userObj);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void invalidEmailExist()
	{
		  
		 UserDAO user = new UserImpl();
		 User userObj = new User();
		try {
			userObj = user.isEmailExist("bwebuihdnwiiwneij@gmail.com");
			assertNull(userObj);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}
	
	}


