package com.revature.charity.validator;

import com.mysql.cj.util.StringUtils;
import com.revature.charity.dao.UserDAO;
import com.revature.charity.dao.UserImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.ContributeList;
import com.revature.charity.model.EmployeeActivity;
import com.revature.charity.model.User;
import com.revature.charity.util.Logger;
import com.revature.charity.util.MessageConstant;

public class UserValidator {
	
	private  UserValidator()
	{}
	
	static  UserValidator userValidator = null;
	
	/**
	 * Get instance of uservalidator class 
	**/
	public static  UserValidator getInstance()
	{
		if(userValidator == null)
		{
			userValidator = new  UserValidator();
		}
		return userValidator;
	}
	
	/** 
	 * Login validator 
	 **/

	public void loginValidator(User user) throws ValidatorException
	{
		String name=user.getName();

		String email = user.getEmail();
		long phone=user.getPhone();
		
		if(StringUtils.isEmptyOrWhitespaceOnly(email))
		{
			throw new ValidatorException(MessageConstant.INVALID_EMAIL);
		}
		if(StringUtils.isEmptyOrWhitespaceOnly(name))
		{
			throw new ValidatorException(MessageConstant.INVALID_NAME);
		}
		if(phone == 0|| "".isBlank())
		{
			throw new ValidatorException(MessageConstant.INVALID_PHONE);
		}
	}
	/** Register validator **/
	public void registerValidator(User user) throws ValidatorException
	{

		String email = user.getEmail();
		String name=user.getName();
		long phone=user.getPhone();
		
		UserDAO userDao = new UserImpl();
		User userobject = new User();
		try {
			userobject = userDao.isEmailExist(email);
			if(userobject != null)
			{
				throw new ValidatorException(MessageConstant.EMAIL_EXIST);
			}
		} catch (DBException e) {
			Logger.error(e);
		}
		
		if(email == null || "".equals(email))
		{
			throw new ValidatorException(MessageConstant.INVALID_EMAIL);
		}
		if(name == null || "".equals(name))
		{
			throw new ValidatorException(MessageConstant.INVALID_NAME);
		}
		if(phone ==0)
		{
			throw new ValidatorException(MessageConstant.INVALID_PHONE);
		}
	}
	/** 
	 * Contribute  validator 
	 **/

	public void contributeValidator(ContributeList user) throws ValidatorException
	{
		int requestid = user.getRequestid();
		double amountdonated=user.getAmountdonated();
		int  userid=user.getUserid();
		
		if(amountdonated == 0|| "".isBlank())
		{
			throw new ValidatorException(MessageConstant.INVALID_AMOUNT);
		}
		if(requestid == 0|| "".isBlank())
		{
			throw new ValidatorException(MessageConstant.INVALID_REQUESTID);
		}
		if(userid == 0|| "".isBlank())
		{
			throw new ValidatorException(MessageConstant.INVALID_USERID);
		}
	}
	
	public void amountUpdateValidator(ContributeList user) throws ValidatorException
	{
		
		double fund=user.getAmountdonated();
		int id=user.getId();
		
		if(fund == 0|| "".isBlank())
		{
			throw new ValidatorException(MessageConstant.INVALID_AMOUNT);
		}
		
		if(id == 0|| "".isBlank())
		{
			throw new ValidatorException(MessageConstant.INVALID_USERID);
		}
	}
	
	
}
