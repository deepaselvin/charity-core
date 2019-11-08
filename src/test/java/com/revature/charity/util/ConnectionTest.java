package com.revature.charity.util;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import com.revature.charity.util.ConnectionProperties;

public class ConnectionTest {
	@Test
	public void connectionTest()
	{
		Connection con = ConnectionProperties.getconnection();
		assertNotNull(con);
	}

}
