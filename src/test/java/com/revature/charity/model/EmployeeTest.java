package com.revature.charity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void test() {
		 Employee employee =new  Employee ();
		 employee.setName("deepa");
		 employee.setPhone(9488544846l);
		 employee.setEmail("deepa@gmaii.com");
		 assertEquals("deepa",employee.getName());
		 assertEquals(9488544846l,employee.getPhone());
		 assertEquals("deepa@gmaii.com",employee.getEmail());
		 
		 
	}

}
