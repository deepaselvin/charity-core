package com.revature.charity.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class userTest {

	@Test
	public void test() {
		User user =new User();
		user.setName("deepa");
		user.setPhone(9488544846l);
		user.setEmail("deepa@gmaii.com");
		 assertEquals("deepa",user.getName());
		 assertEquals(9488544846l,user.getPhone());
		 assertEquals("deepa@gmaii.com",user.getEmail());
		 
	
	}

}
