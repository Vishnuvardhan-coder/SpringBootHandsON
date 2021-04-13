package com.trientra;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trientra.employee.entity.Employee;
import com.trientra.employee.service.EmployeeService;

@SpringBootApplication
public class SpringbootDataJpa2Application {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostConstruct
	public void init() {
		
		List<Employee> findAll = employeeService.findAll();
		findAll.forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpa2Application.class, args);
	}

}
