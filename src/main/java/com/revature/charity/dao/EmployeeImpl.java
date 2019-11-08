package com.revature.charity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Employee;
import com.revature.charity.util.ConnectionProperties;


public class EmployeeImpl implements EmpolyeeDAO {

	public Boolean adminRegister(Employee request) throws DBException, SQLException  {
		
		Connection con = null;
		PreparedStatement pst = null;
		Boolean isStatus = false;
	
		try {
			String sql = "insert into admin_users(name,email,phone_number) values (?,?,?)";
			con = ConnectionProperties.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, request.getName());
			pst.setString(2, request.getEmail());
			pst.setLong(3, request.getPhone());
			int rows = pst.executeUpdate();

			if (rows == 1) {
				isStatus = true;
			}

		}
		catch (SQLException e) {
			throw new DBException("Invalid Register Crendentails");
		}
		finally {
			ConnectionProperties.close(con, pst);
		}
		return isStatus;
	
	}

	public Employee adminLogin(Employee request) throws DBException  {

		Connection con = null;
		PreparedStatement pst = null;
		Employee userobj = null;
		ResultSet result=null;
		
		try {
			String sql = "select * from admin_users where name=? and email=? and phone_number=? ";
			
			con = ConnectionProperties.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, request.getName());
			pst.setString(2, request.getEmail());
			pst.setLong(3, request.getPhone());
			result = pst.executeQuery();
		//	System.out.println("result::::"+result);
			
			if (result.next()) {
				userobj = new Employee();
				userobj.setId(result.getInt("id"));
				userobj.setName(result.getString("name"));
				userobj.setEmail(result.getString("email"));
				userobj.setPhone(result.getLong("phone_number"));
			}
		
	} catch (SQLException e) {
		
			throw new DBException("Invalid Login Crendentails");
		} finally {
			ConnectionProperties.close(con, pst, result);
		}
		return userobj;
		
	
	
	}



	
}
