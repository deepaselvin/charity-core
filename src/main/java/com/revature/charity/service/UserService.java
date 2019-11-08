package com.revature.charity.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.model.EmployeeActivity;
import com.revature.charity.model.User;

public interface UserService {

	public boolean donorRegister(User user) throws Exception;
	public User login(User user) throws DBException ,ServiceException;

	public boolean fundUpdate (ContributeList user) throws DBException, ServiceException, SQLException ;

	public boolean contribute (ContributeList user) throws DBException, ServiceException, SQLException ;

	public List<EmployeeActivity> requestList() throws ServiceException, SQLException;
}
