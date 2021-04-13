package com.trientra.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trientra.employee.entity.Employee;
import com.trientra.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findByNameAndSalary(String name, Double salary) {
		return employeeRepository.findByNameAndSalary(name, salary);

	}

	public List<Employee> getAll() {
		return employeeRepository.getAllEmployees();
	}

}
