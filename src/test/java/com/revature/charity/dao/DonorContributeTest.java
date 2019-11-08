package com.revature.charity.dao;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.charity.dao.UserActivityDAO;
import com.revature.charity.dao.UserActivityImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.util.Logger;

public class DonorContributeTest {


	@Test
	public void validContributeTest() throws SQLException {
		UserActivityDAO user=new UserActivityImpl();
		ContributeList userObj=new ContributeList();
		Boolean isStatus = null;
		
		userObj.setAmountdonated(200);
		userObj.setRequestid(1);
		userObj.setUserid(1);
		try {
			isStatus = user.insert(userObj);
			assertEquals(true, isStatus);
		}
		catch (DBException e) {
			Logger.error(e.getMessage());
		}	
	}
	@Test
	public void invalidContributeTest() throws SQLException {
		UserActivityDAO user=new UserActivityImpl();
		ContributeList userObj=new ContributeList();
		Boolean isStatus = null;
		
		userObj.setAmountdonated(0);
		userObj.setRequestid(0);
		userObj.setUserid(0);
		try {
			isStatus = user.insert(userObj);
			assertEquals(false, isStatus);
		}
		catch (DBException e) {
			Logger.error(e.getMessage());
		}
		
	
	}

}

