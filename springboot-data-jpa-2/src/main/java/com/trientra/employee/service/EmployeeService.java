package com.trientra.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trientra.employee.dao.EmployeeDao;
import com.trientra.employee.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	
	public List<Employee> findAll(){
		
		return employeeDao.getAll();
	}
	

}
