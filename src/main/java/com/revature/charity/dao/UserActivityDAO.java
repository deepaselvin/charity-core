package com.revature.charity.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.model.EmployeeActivity;

public interface UserActivityDAO {
	public boolean insert(ContributeList user) throws SQLException, DBException;
	public boolean update(ContributeList user) throws SQLException, DBException ;
	public List<EmployeeActivity> requestList() throws SQLException, DBException;
}
