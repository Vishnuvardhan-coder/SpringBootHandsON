package com.trientra;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDataJpaApplication {
	
	@Autowired
 private EmployeeRepository employeeRepository;
	@PostConstruct
	public void init() {
		Employee employee = new Employee(1,"vishnu",50000d);
		Employee employee2 = employeeRepository.save(employee);
		System.out.println(employee2.getName());
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaApplication.class, args);
	}

}
