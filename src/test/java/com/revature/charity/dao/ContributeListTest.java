package com.revature.charity.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.revature.charity.dao.EmployeeActivityImpl;
import com.revature.charity.dao.EmployeeActivityDAO;
import com.revature.charity.exception.DBException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.util.Logger;

public class ContributeListTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void validListTest() throws SQLException {
		{
			EmployeeActivityDAO donorObj = new EmployeeActivityImpl();
			List<ContributeList> list=null;
			try {
				
				list = donorObj.contribute();
				assertNotNull(list);
				Logger.info(list);
			} catch (DBException e) {
			Logger.error(e.getMessage());
			}
		}
	}

	
	

}
