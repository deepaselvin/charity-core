package com.revature.charity.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.revature.charity.dao.EmployeeActivityDAO;
import com.revature.charity.dao.EmployeeActivityImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.model.User;
import com.revature.charity.util.Logger;

public class ListDonorTest {


	@Test
	public void listDonorTest() throws SQLException {
		{
			EmployeeActivityDAO donorObj = new EmployeeActivityImpl();
			List<User> list=null;
			try {
				
				list = donorObj.donorRegister();
				System.out.println(list);
				assertNotNull(list);
				Logger.info(list);
			} catch (DBException e) {
			Logger.error(e.getMessage());
			}
		}
		
	}

}
