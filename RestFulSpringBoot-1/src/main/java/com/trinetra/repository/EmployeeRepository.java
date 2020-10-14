package com.trinetra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trinetra.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
