package com.revature.charity.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Employee;
import com.revature.charity.util.Logger;

public class EmployeeServiceLoginTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void validServiceLoginTest() throws Exception {
		EmployeeService service = new EmployeeServiceImpl();
		 
		Employee user = new Employee();
		Employee userObj = new Employee();
		user.setName("pradeepa");
		user.setEmail("pradeepa@gmaii.com");
		user.setPhone(9488544846l);
	
		try {
			userObj = service.login(user);
			System.out.println(userObj);

			assertNotNull(userObj);
		} catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
	}
	@Test
	public void invalidServiceLoginTest() throws Exception {
		EmployeeService service = new EmployeeServiceImpl();
		 
		Employee user = new Employee();
		Employee userObj = new Employee();
		user.setName("pa");
		user.setEmail("pa@gmaii.com");
		user.setPhone(94885454844546l);
	
		try {
			userObj = service.login(user);
			System.out.println(userObj);

			assertNotNull(userObj);
		} catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
	}

	
}



