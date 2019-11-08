package com.revature.charity.dao;

import java.sql.SQLException;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Employee;

public interface EmpolyeeDAO {
	public Boolean  adminRegister(Employee user) throws DBException, SQLException  ;

	public Employee adminLogin(Employee user) throws DBException;
	
	
}
