package com.revature.charity.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.charity.dao.EmployeeActivityDAO;
import com.revature.charity.dao.EmployeeActivityImpl;
import com.revature.charity.dao.EmployeeImpl;
import com.revature.charity.dao.EmpolyeeDAO;
import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.model.Employee;
import com.revature.charity.model.EmployeeActivity;
import com.revature.charity.model.User;
import com.revature.charity.util.Logger;
import com.revature.charity.util.MessageConstant;

/** Employee Activity **/
public class EmployeeServiceImpl implements EmployeeService{

	private static final String EXCEPTION = "EXCEPTION";
	static EmployeeActivityDAO employeeAct = new EmployeeActivityImpl();
	static EmpolyeeDAO employeeDao = new EmployeeImpl();

	/**
	 * Employee Register
	 * 
	 * @throws ServiceException
	 **/

	public void adminRegister(Employee request) throws ServiceException {
		try {
			employeeDao.adminRegister(request);
		} catch (DBException e) {
			Logger.error(EXCEPTION+e.getMessage());
			throw new ServiceException(e.getMessage());

		} catch (SQLException e) {

			Logger.error(EXCEPTION+e.getMessage());
		}
	}

	/**
	 * Employee Login
	 * 
	 * @throws ServiceException
	 **/
	public Employee login(Employee request) throws DBException, ServiceException {

		Employee userResponse = null;
		try {
			userResponse=new Employee();
			userResponse = employeeDao.adminLogin(request);

			if (userResponse == null) {
				throw new ServiceException(MessageConstant.INVALID_EMAIL);
			}
		} catch (DBException e) {
			Logger.error(EXCEPTION+e.getMessage());
		}
		return userResponse;

	}

	/**
	 * Donation List
	 * 
	 * @throws ServiceException
	 **/

	public List<ContributeList> contribute() throws ServiceException {

		List<ContributeList> list = null;
		try {
			list = employeeAct.contribute();
		} catch (SQLException e) {
			Logger.error(EXCEPTION+e.getMessage());

		} catch (DBException e) {

			Logger.error(EXCEPTION+e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return list;
	}

	/** User List **/
	public List<User> userList() throws ServiceException {

		List<User> list = null;
		try {
			list = employeeAct.donorRegister();
		} catch (SQLException e) {
			Logger.error(EXCEPTION+e.getMessage());

		} catch (DBException e) {

			Logger.error(e.getMessage());
			throw new ServiceException(EXCEPTION+e.getMessage());
		}
		return list;
	}

	/**
	 * Update The Fund Need and Amount
	 * @throws DBException
	 **/

	public void adminInsert(EmployeeActivity request) throws DBException {
		try {
			employeeAct.insertRequest(request);
		} 
		catch (SQLException e) {
			Logger.error(EXCEPTION+e.getMessage());
		}
		catch (DBException e) {
			Logger.error(EXCEPTION+e.getMessage());
			throw new DBException(e.getMessage());

		}
	}
	
	/**
	 * Update The Fund Need and Amount
	 * @throws DBException
	 **/
	public void adminRequestUpdate(EmployeeActivity request) throws DBException {
		try {
			employeeAct.updateReqFund(request);
		}
		catch (SQLException e) {
			Logger.error(e.getMessage());
         }
		catch (DBException e) {
			Logger.error(EXCEPTION+e.getMessage());
			throw new DBException(e.getMessage());
}
		
	}

}
