package com.trinetra.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trinetra.model.Employee;
import com.trinetra.repository.EmployeeRepository;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;

// to save an employee

	public Employee save(Employee emp) {

		return employeeRepository.save(emp);
	}

// to list all employees

	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();

	}

// to get employee

	public Employee findOne(Long eid) {

		return employeeRepository.getOne(eid);
	}

// to delete employee

	public void deleteEmployee(Employee emp) {

		this.employeeRepository.delete(emp);
	}

}
