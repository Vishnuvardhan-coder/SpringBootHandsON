package com.trientra;

import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends Repository<Employee, Integer> {
	
	public Employee save(Employee employee);

}
