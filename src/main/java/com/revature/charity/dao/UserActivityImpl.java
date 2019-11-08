package com.revature.charity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.model.EmployeeActivity;
import com.revature.charity.util.ConnectionProperties;

public class UserActivityImpl implements UserActivityDAO {
	 

	public  boolean insert(ContributeList user) throws SQLException, DBException {
		Connection con = null;
		PreparedStatement pst = null;
		Boolean isStatus = false;
		
		
		 try {
			 String sql = "insert into user_activity(user_id,request_id,amount_donated) values (?,?,?)";
				
			con = ConnectionProperties.getconnection();
			pst = con.prepareStatement(sql);
			pst.setLong(1, user.getUserid());
			pst.setInt(2, user.getRequestid());
			pst.setDouble(3, user.getAmountdonated());
			int rows = pst.executeUpdate();
			

			if (rows == 1) {
				isStatus = true;
			}

		} catch (SQLException e) {
			
		 	 
			throw new DBException("unable to select");
		} finally {
			ConnectionProperties.close(con, pst);
		}
		 return isStatus;
	}

	public boolean update(ContributeList user) throws SQLException, DBException {

		Connection con = null;
		PreparedStatement pst = null;
		Boolean isStatus = false;
		
		
		 try {
			 String sql = "update category set fund_needed= fund_needed - ? where id=?";	
			con = ConnectionProperties.getconnection();
			pst = con.prepareStatement(sql);
			 pst.setDouble(1, user.getAmountdonated());
	            pst.setInt(2, user.getId());
	       
			int rows = pst.executeUpdate();
			if (rows == 1) {
				isStatus = true;
			}
			
		} catch (SQLException e) {
		 	 
			throw new DBException("unable to select");
		} finally {
			ConnectionProperties.close(con, pst);
		}
		return isStatus;
	}

	public  List<EmployeeActivity> requestList() throws SQLException, DBException {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result =null;
		List<EmployeeActivity> list=null;
		try {
			con = ConnectionProperties.getconnection();
			String sql1 = "select * from category ";
			pst = con.prepareStatement(sql1);
			result = pst.executeQuery();
		 list = new ArrayList<EmployeeActivity>();
			while (result.next()) 
			{
				EmployeeActivity user = toRow(result);
				list.add(user);
			}
			
		}	catch (SQLException e) {
			throw new DBException("unable to select");
		}finally {
			ConnectionProperties.close(con, pst);
		}
		return list;
	}

	private static EmployeeActivity toRow(ResultSet result) throws SQLException {

		String request= result.getString("request_type");
		double fund=result.getDouble("fund_needed") ;

		EmployeeActivity user = new EmployeeActivity();
		user.setRequest(request);
		user.setFund(fund);

		return user;
	}

}
