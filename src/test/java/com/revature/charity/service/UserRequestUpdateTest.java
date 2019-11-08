package com.revature.charity.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.util.Logger;

public class UserRequestUpdateTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void validTest() throws Exception 
	{
		
		UserService service = new UserServiceImpl();
		ContributeList user = new ContributeList();
		user.setAmountdonated(100);
		user.setRequestid(1);
		user.setId(1);
		Boolean isRegister = null;
		try {
			isRegister = service.contribute(user);
			System.out.println(isRegister);
			assertEquals(false, isRegister);
		} catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
}
	
	@Test
	public void invalidTest() throws Exception 
	{
		
		UserService service = new UserServiceImpl();
		ContributeList user = new ContributeList();
		user.setAmountdonated(0);
		user.setRequestid(0);
		user.setId(0);
		Boolean isRegister = null;
		try {
			isRegister = service.contribute(user);
			System.out.println(isRegister);
			assertEquals(false, isRegister);
		} catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
}
}
