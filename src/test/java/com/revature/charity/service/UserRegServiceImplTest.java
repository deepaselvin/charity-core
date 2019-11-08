package com.revature.charity.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.User;
import com.revature.charity.service.UserService;
import com.revature.charity.service.UserServiceImpl;
import com.revature.charity.util.Logger;

public class UserRegServiceImplTest {
	@Test
	public void validRegServiceTest() throws Exception {
		UserService service = new UserServiceImpl();
		User user = new User();
		user.setName("test");
		user.setEmail("test@gmail.com");
		user.setPhone(9488544846l);
		Boolean isRegister = null;
		try {
			isRegister = service.donorRegister(user);
			assertEquals(false, isRegister);
		} catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
	}
	
	@Test
	public void invalidRegServiceTest() throws Exception {
		UserService service = new UserServiceImpl();
		User user = new User();
		user.setName("t");
		user.setEmail("t@gmail.com");
		user.setPhone(948855451548787l);
		Boolean isRegister = null;
		try {
			isRegister = service.donorRegister(user);
			assertEquals(false, isRegister);
		} catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
	}
}