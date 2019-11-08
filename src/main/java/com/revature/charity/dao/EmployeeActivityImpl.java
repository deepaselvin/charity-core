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
import com.revature.charity.model.User;
import com.revature.charity.util.ConnectionProperties;

public class EmployeeActivityImpl implements EmployeeActivityDAO {

	public List<ContributeList> contribute() throws SQLException, DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;
        List<ContributeList> list = null;

		try {

			con = ConnectionProperties.getconnection();
			String sql1 = "select name,request_id,amount_donated from users u,user_activity a where u.id=a.user_id";
			pst = con.prepareStatement(sql1);
			result = pst.executeQuery();
			list = new ArrayList<ContributeList>();
			while (result.next()) {
				ContributeList user = toRow(result);

				list.add(user);
			}

		} catch (SQLException e) {

			throw new DBException("unable to select");
		} finally {
			ConnectionProperties.close(con, pst, result);
		}
		return list;

	}

	private ContributeList toRow(ResultSet result) throws SQLException, DBException {
		ContributeList user = new ContributeList();

		try {
			String name = result.getString("name");
			int requestid = result.getInt("request_id");
			int amountdonated = result.getInt("amount_donated");

			user.setName(name);
			user.setRequestid(requestid);
			user.setAmountdonated(amountdonated);

		} catch (SQLException e) {
			throw new DBException("unable to select");
		}
		return user;
	}

	public List<User> donorRegister() throws SQLException, DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		List<User> list = null;

		try {

			con = ConnectionProperties.getconnection();
			String sql1 = " select * from users ";
			pst = con.prepareStatement(sql1);
			result = pst.executeQuery();
			list = new ArrayList<User>();
			while (result.next()) {
				User use = toRow1(result);
				list.add(use);
			}

		} catch (SQLException e) {

			throw new DBException("query error");
		} finally {
			ConnectionProperties.close(con, pst);
		}
		return list;

	}

	private User toRow1(ResultSet result) throws SQLException {

		String name = result.getString("name");
		String email = result.getString("email");
		long phone = result.getLong("phone_number");

		User user = new User();

		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);

		return user;
	}

	public boolean insertRequest(EmployeeActivity request) throws SQLException, DBException {
		Connection con = null;
		PreparedStatement pst = null;
		Boolean isStatus = false;

		try {
			String sql = "insert into category(request_type,fund_needed) values (?,?)";
			con = ConnectionProperties.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, request.getRequest());
			pst.setDouble(2, request.getFund());
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

	public void updateReqFund(EmployeeActivity request) throws SQLException, DBException {

		Connection con = null;
		PreparedStatement pst = null;

		try {
			String sql = "update category  set fund_needed=? where id=?";
			con = ConnectionProperties.getconnection();
			pst = con.prepareStatement(sql);
			pst.setDouble(1, request.getFund());
			pst.setInt(2,request.getId());

			pst.executeUpdate();

		} catch (SQLException e) {
            e.printStackTrace();
			throw new DBException("unable to select");
		} finally {
			ConnectionProperties.close(con, pst);
		}
	}

}
