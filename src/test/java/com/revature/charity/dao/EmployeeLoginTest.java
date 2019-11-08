package com.revature.charity.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.charity.dao.EmployeeImpl;
import com.revature.charity.dao.EmpolyeeDAO;
import com.revature.charity.exception.DBException;
import com.revature.charity.model.Employee;
import com.revature.charity.util.Logger;

public class EmployeeLoginTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void validLoginTest () {
		
		EmpolyeeDAO empolyee= new EmployeeImpl();
		Employee user= new Employee();
		Employee userObj= new Employee();
		user.setName("pradeepa");
		user.setEmail("pradeepa@gmaii.com");
		user.setPhone(9488544846l);
		try {
			userObj = empolyee.adminLogin(user);
			System.out.println(userObj);
			assertNotNull(userObj);
		} catch (DBException e) {
			Logger.debug(e.getMessage());
		}
	}
	
	@Test
	public void invalidLoginTest () {
		
		EmpolyeeDAO empolyee= new EmployeeImpl();
		Employee user= new Employee();
		Employee userObj= new Employee();
		user.setName("zzzzzzzzzzzzzz");
		user.setEmail("zzzzzzz@gmaii.com");
		user.setPhone(1236541123l);
		try {
			userObj = empolyee.adminLogin(user);
			System.out.println(userObj);
			assertNull(userObj);
		} catch (DBException e) {
			Logger.debug(e.getMessage());
		}
	}
		

}

