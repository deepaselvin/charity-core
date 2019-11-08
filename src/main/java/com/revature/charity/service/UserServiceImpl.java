package com.revature.charity.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.charity.dao.UserActivityDAO;
import com.revature.charity.dao.UserActivityImpl;
import com.revature.charity.dao.UserDAO;
import com.revature.charity.dao.UserImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.model.EmployeeActivity;
import com.revature.charity.model.User;
import com.revature.charity.util.Logger;
import com.revature.charity.util.MailUtil;
import com.revature.charity.util.MessageConstant;
import com.revature.charity.validator.UserValidator;

/** User Registration **/
public class UserServiceImpl implements UserService {

	static UserDAO userDao = new UserImpl();
	static UserActivityDAO userObject = new UserActivityImpl();

	public boolean donorRegister(User user) throws Exception {

		Boolean isRegister = false;
		UserValidator userValidator = UserValidator.getInstance();

		try {
			userValidator.registerValidator(user);
			isRegister = userDao.donorRegister(user);
			if (Boolean.FALSE.equals(isRegister)) {
				throw new ServiceException(MessageConstant.UNABLE_TO_REGISTER);
			} else {
				// email verification
				String host = "smtp.gmail.com";
				String username = "pradeepaselvin97@gmail.com";
				String password = "dptuwenukcjsiltu";
				String fromAddress = "pradeepaselvin97@gmail.com";
				String toAddress = "ennilla007@gmail.com";
				String subject = "Test mail";
				String text = "This is a sample message. Thank you.";
				MailUtil.sendMailUsingTLS(host, username, password, fromAddress, toAddress, subject, text);
				MailUtil.sendMailUsingSSL(host, username, password, fromAddress, toAddress, subject, text);
			}
		} catch (DBException e) {
			Logger.error(e.getMessage());
		} catch (ValidatorException e) {
			Logger.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return isRegister;
	}

	/** User Login 
	 * @throws DBException
	 * returns Boolean **/

	public User login(User user) throws DBException, ServiceException {

		User userResponse = null;
		try {
			userResponse = userDao.donorLogin(user);

			if (userResponse == null) {
				throw new ServiceException(MessageConstant.INVALID_EMAIL);
			}
		} catch (DBException e) {
			Logger.error(e.getMessage());
		}
		return userResponse;

	}

	/**
	 * Contribute To Request
	 * 
	 * @throws SQLException
	 * returns Boolean 
	 **/

	public boolean contribute(ContributeList user) throws DBException, ServiceException, SQLException {

		Boolean isStatus = false;
		UserValidator userValidator = UserValidator.getInstance();

		try {
			userValidator.contributeValidator(user);
			isStatus = userObject.insert(user);

			if (Boolean.FALSE.equals(isStatus)) {
				throw new ServiceException(MessageConstant.UNABLE_TO_REGISTER);
			}

		} catch (DBException e) {
			Logger.error(e.getMessage());
		} catch (ValidatorException e) {
			Logger.error(e.getMessage());
		}
		return isStatus;
	}

	public boolean fundUpdate(ContributeList user) throws DBException, ServiceException, SQLException {

		Boolean isStatus = false;
		UserValidator userValidator = UserValidator.getInstance();

		try {
			userValidator.amountUpdateValidator(user);
			isStatus = userObject.update(user);

			if (Boolean.FALSE.equals(isStatus)) {
				throw new ServiceException(MessageConstant.UNABLE_TO_REGISTER);
			}

		} catch (DBException e) {
			Logger.error(e.getMessage());
		} catch (ValidatorException e) {
			Logger.error(e.getMessage());
		}
		return isStatus;

	}

	/**
	 * View Request list
	 * 
	 * @throws SQLException
	 **/
	public List<EmployeeActivity> requestList() throws ServiceException, SQLException {
		List<EmployeeActivity> list = null;
		try {
			list = userObject.requestList();
		} catch (DBException e) {
			Logger.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return list;
	}

}