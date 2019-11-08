package com.revature.charity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeActivityTest {

	@Test
	public void test() {
		EmployeeActivity employee = new EmployeeActivity(); 
		employee.setFund(150.0);
		employee.setRequest("Maintance");
		assertEquals("Maintance",employee.getRequest());
	
	
	
	}

}
