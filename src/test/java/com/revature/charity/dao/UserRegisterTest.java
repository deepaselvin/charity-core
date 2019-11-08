package com.revature.charity.dao;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.revature.charity.dao.UserDAO;
import com.revature.charity.dao.UserImpl;
import com.revature.charity.model.User;
import com.revature.charity.util.Logger;

public class UserRegisterTest {

	@Test
	public void validRegisterTest() 
	{
		Boolean isLoggedIn = null;
		UserDAO userDAO = new UserImpl();
		User user = new User();
		user.setName("insert");
		user.setEmail("insert@gmail.com");
		user.setPhone(9488543846l);
		
	        try {
	        	isLoggedIn = userDAO.donorRegister(user);
	        	assertEquals(true, isLoggedIn);
			} catch (Exception e) {
				Logger.debug(e.getMessage());		
			}
	}
	
	@Test
	public void invalidRegisterTest() 
	{
		Boolean isLoggedIn = null;
		UserDAO userDAO = new UserImpl();
		User user = new User();
		user.setName("");
		user.setEmail("");
		user.setPhone(9488546l);
		
	        try {
	        	isLoggedIn = userDAO.donorRegister(user);
	        	assertEquals(true, isLoggedIn);
			} catch (Exception e) {
				Logger.debug(e.getMessage());		
			}
	}
}


