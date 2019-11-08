package com.revature.charity.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.charity.dao.EmployeeActivityDAO;
import com.revature.charity.dao.EmployeeActivityImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.model.EmployeeActivity;
import com.revature.charity.util.Logger;

public class FundRequestTest {


	@Test
	public void validRequesTest() throws SQLException {
		
		  EmployeeActivityDAO   fundRequest = new EmployeeActivityImpl();
		  EmployeeActivity user = new EmployeeActivity();
		Boolean isStatus = null;
		try {
			user.setFund(5000);
			user.setRequest("Education");
			isStatus = fundRequest.insertRequest(user);
			assertEquals(true, isStatus);
		} catch (DBException e) {
			Logger.error(e.getMessage());
		}	
	}

	@Test
	public void invalidRequesTest() throws SQLException {
		
		  EmployeeActivityDAO   fundRequest = new EmployeeActivityImpl();
		  EmployeeActivity user = new EmployeeActivity();
		Boolean isStatus = null;
		try {
			user.setFund(0);
			user.setRequest("E");
			isStatus = fundRequest.insertRequest(user);
			assertEquals(true, isStatus);
		} catch (DBException e) {
			Logger.error(e.getMessage());
		}	
	}

	
}
