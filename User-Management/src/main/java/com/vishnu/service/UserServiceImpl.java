package com.vishnu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.entity.City;
import com.vishnu.entity.Country;
import com.vishnu.entity.State;
import com.vishnu.entity.User;
import com.vishnu.repository.CityRepository;
import com.vishnu.repository.CountryRepository;
import com.vishnu.repository.StateRepository;
import com.vishnu.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Map<Integer, String> findCountries() {
	
		List<Country> countriesList = countryRepo.findAll();
		Map<Integer,String> countries = new HashMap<>();
		
		countriesList.forEach(country -> {
			countries.put(country.getCountryId(), country.getCountryName());
		});
		
		return countries;
		
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {

		List<State> stateList = stateRepo.findByCountryId(countryId);
	    Map<Integer, String> states = new HashMap<>();
		stateList.forEach(state -> {
		          states.put(state.getStateId(), state.getStateName());
		});
	
		return states;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {
		Map<Integer,String> cities = new HashMap<>();
		List<City> citiesList = cityRepo.findByStateId(stateId);
		citiesList.forEach(city ->{
			cities.put(city.getCityId(), city.getCityName());
		});
		
		
		return cities;
	}

	@Override
	public boolean isEmailUnique(String emailId) {

		 User userDetails = userRepo.findByEmailId(emailId);
		return userDetails.getUserId()==null;
	}

	@Override
	public boolean saveUser(User user) {
		user.setPassword(passwordGenerator());
		user.setAccStatus("LOCKED");
		User  userObj = userRepo.save(user);
		return userObj.getUserId() != null;
	}

	private String passwordGenerator() {
		char [] password = new char[5];
		String alphanumeric = "ABCDEFGHabcdefgh1234567890";
		Random randomPwd = new Random();
		for(int i=0 ; i<5; i++) {
			
			password[i] = alphanumeric.charAt(randomPwd.nextInt(alphanumeric.length()));
		}
		System.out.println(password.toString());
		return password.toString();
	}

	//test case-1 : invalid email & password ==> INVALID CREDENTIALs
	// test case-2 : valid email & password & acc is LOCKED ==> ACCOUNT_LOCKED
	// test case-3 : valid email , pwd & acc UNLOCKED ==> LOGIN_SUCCESS
	@Override
	public String loginCheck(String email, String pwd) {
                 
	 User userDetails = userRepo.findByEmailIdAndPassword(email,pwd);
	 
	 if(userDetails!=null) {
	 if(userDetails.getAccStatus().equals("LOCKED")) {
	
	 return "ACCOUNT_LOCKED";
		
	 }else {
		 return "LOGIN_SUCCESS";
	 }
	 }
		return "INVALID_CREDENTIALS";
	}

	

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		
		User userDetails = userRepo.findByEmailIdAndPassword(email,tempPwd);
		
		return userDetails.getUserId() !=null;
	}

	@Override
	public boolean unlockAccount(String email, String newPwd) {
             User userDetails = userRepo.findByEmailId(email);
             userDetails.setPassword(newPwd);
             userDetails.setAccStatus("UNLOCKED");
            try {
            	
             userRepo.save(userDetails);
             return true;
		
            }catch (Exception e){
            	e.printStackTrace();
            	return false;
            	
            }
	}

	@Override
	public String forgotPassword(String email) {
		
		User userDetails = userRepo.findByEmailId(email);
		
		if(userDetails!=null) {
		return userDetails.getPassword();
		}
		return null;
	}

}
