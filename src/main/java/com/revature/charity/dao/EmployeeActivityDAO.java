package com.revature.charity.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.model.EmployeeActivity;
import com.revature.charity.model.User;

public interface EmployeeActivityDAO {
	public List<ContributeList> contribute() throws SQLException, DBException;
	public boolean  insertRequest(EmployeeActivity request) throws SQLException, DBException;
	public void updateReqFund (EmployeeActivity request) throws SQLException, DBException ;
	public  List<User> donorRegister() throws SQLException, DBException ;
}
