package com.revature.charity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.User;
import com.revature.charity.util.ConnectionProperties;
import com.revature.charity.util.MessageConstant;

public class UserImpl implements UserDAO {
	

	public Boolean donorRegister(User user) throws DBException {
		
		Connection con = null;
		PreparedStatement pst = null;
		Boolean result = false;

		String sql = "insert into users(name,email,phone_number) values (?,?,?)";
		 try {
			con = ConnectionProperties.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setLong(3, user.getPhone());
			int rows = pst.executeUpdate();

				if(rows == 1)
				{
					result = true;
				}
			
		} catch (SQLException e) {
			throw new DBException("INVALID USERNAME AND PHONE NO");
		} finally {
			ConnectionProperties.close(con, pst);
		}
			return result;	
	
		
	}
	
	public User donorLogin(User user) throws DBException{


		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result=null;
		User userObject = null;

		
		String sql = "select * from users where name=? and  email=? and phone_number=?";

		try {
			con = ConnectionProperties.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1,user.getName());
			pst.setString(2, user.getEmail());
			pst.setLong(3, user.getPhone());
			 result = pst.executeQuery();

			if (result.next()) {
				userObject = new User();
				userObject.setId(result.getInt("id"));
				userObject.setName(result.getString("name"));
				userObject.setEmail(result.getString("email"));
				userObject.setPhone(result.getLong("phone_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to select");
		} finally {
			
			ConnectionProperties.close(con, pst, result);
		}
		return userObject;
	}



	public User isEmailExist(String email) throws DBException
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		User userObject = null;

		try {
			con = ConnectionProperties.getconnection();
			String sql = "select name,email from users where email = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			result = pst.executeQuery();
			if(result.next())
			{
				userObject = new User();
				userObject.setName(result.getString("name"));
				userObject.setEmail(result.getString("email"));
			}
		} catch(SQLException e)
		{
			throw new DBException(MessageConstant.UNABLE_TO_CHECK_EMAIL,e);
		} finally {
			ConnectionProperties.close(con, pst, result);
		}
		return userObject;
	}
	
}
