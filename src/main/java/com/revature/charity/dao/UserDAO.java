package com.revature.charity.dao;


import com.revature.charity.exception.DBException;
import com.revature.charity.model.User;

public interface UserDAO {

	public Boolean donorRegister(User user) throws DBException;
	public User donorLogin(User user) throws DBException;
	public User isEmailExist(String email)throws DBException;

}
