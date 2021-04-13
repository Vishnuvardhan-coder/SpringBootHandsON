package com.trientra.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.trientra.employee.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	
	public List<Employee> findByName(String name);
	
	public List<Employee> findByNameAndSalary(String name, Double salary);
	
	@Query("select e from Employee e")
	public List<Employee> getAllEmployees();

}
