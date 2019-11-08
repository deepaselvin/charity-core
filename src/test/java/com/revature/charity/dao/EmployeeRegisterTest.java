package com.revature.charity.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.revature.charity.dao.EmployeeImpl;
import com.revature.charity.dao.EmpolyeeDAO;
import com.revature.charity.model.Employee;
import com.revature.charity.util.Logger;

public class EmployeeRegisterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void validRegisterTest() throws SQLException {
		EmpolyeeDAO empolyee= new EmployeeImpl();
		Employee request= new Employee();
		Boolean isLoggedIn = null;
		request.setName("selvinraj");
		request.setEmail("selvinraj@gmaii.com");
		request.setPhone(9952533094l);
		try {
			isLoggedIn = empolyee.adminRegister(request);
		 	assertEquals(true, isLoggedIn);
		} catch (Exception e) {
			Logger.debug(e.getMessage());		
		}
	}
		
		@Test
		public void invaliddRegisterTest() throws SQLException {
			EmpolyeeDAO empolyee= new EmployeeImpl();
			Employee request= new Employee();
			Boolean isLoggedIn = null;
			request.setName("ookkjgf");
			request.setEmail("hhhbbggggg@gmaii.com");
			request.setPhone(90000021454l);
			try {
				isLoggedIn = empolyee.adminRegister(request);
			 	assertEquals(true, isLoggedIn);
			} catch (Exception e) {
				Logger.debug(e.getMessage());		
			}
	}

}
