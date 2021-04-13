package com.vishnu.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.vishnu.entity.User;

public interface IUserService {

	//Registration Page Operations
	public Map<Integer,String> findCountries();
	
	public Map<Integer,String> findStates(Integer countryId);
	
	Map<Integer, String> findCities(Integer stateId);
	
	public boolean isEmailUnique(String emailId);
	
	public boolean saveUser(User u);
	
	//Login Page Operations
	public String loginCheck(String email,String pwd);//it has to check 2 conditions thats y its string
	
	//Unlock Account Operations
	public boolean isTempPwdValid(String email, String tempPwd);
	public boolean unlockAccount(String email, String newPwd);
	
	//forgot password
	public String forgotPassword(String email);

	
	
	
	
}
