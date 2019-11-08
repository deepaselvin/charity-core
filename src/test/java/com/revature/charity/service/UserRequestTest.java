package com.revature.charity.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.charity.dao.UserActivityDAO;
import com.revature.charity.dao.UserActivityImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.model.EmployeeActivity;
import com.revature.charity.util.Logger;

public class UserRequestTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
		public void requesListTest() throws SQLException 
			{
				UserActivityDAO userObj = new UserActivityImpl();
				List<EmployeeActivity> list = null; 
				try {
					
					list = userObj.requestList();
					assertNotNull(list);
					Logger.info(list);
				} catch (DBException e) {
				Logger.error(e.getMessage());
				}
			}
		
		
	}


