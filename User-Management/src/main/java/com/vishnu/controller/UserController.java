package com.vishnu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.entity.User;
import com.vishnu.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/getCountries")
	public Map<Integer, String> findCountries() {
		return userService.findCountries();

	}

	@GetMapping("/getStates/{countryId}")
	public Map<Integer, String> findStates(@PathVariable Integer countryId) {
		return userService.findStates(countryId);
	}

	@GetMapping("/getCities/{stateId}")
	public Map<Integer, String> findCities(@PathVariable Integer stateId) {
		return userService.findCities(stateId);

	}

	@GetMapping("/emailCheck/{email}")
	private String isEmailUnique(@PathVariable String email) {
		if(userService.isEmailUnique(email)){
			return "true";
		}
		return "false";
	}
	
	@PostMapping(value = "/registration", consumes= {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> userRegistration(@RequestBody User user) {
	
	if(userService.isEmailUnique(user.getEmailId())) {
		 userService.saveUser(user);
		 return new ResponseEntity<>("Registration Success",HttpStatus.CREATED);
	}
	return new ResponseEntity<>("Registration Failed",HttpStatus.BAD_REQUEST);
	}
	
}
