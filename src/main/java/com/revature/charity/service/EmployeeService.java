package com.revature.charity.service;

import java.util.List;

import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.model.Employee;
import com.revature.charity.model.EmployeeActivity;
import com.revature.charity.model.User;

public interface EmployeeService {

	public void adminRegister(Employee user) throws ServiceException;
	public Employee login(Employee user) throws DBException, ServiceException ;

public List<ContributeList> contribute() throws ServiceException ;
	public List<User> userList() throws ServiceException ;
	public void adminInsert(EmployeeActivity request) throws DBException ;
	public void adminRequestUpdate(EmployeeActivity request) throws DBException ;

}
