package com.trientra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "emp_tbl")
public class Employee {

	@Id
	private Integer eno;
	private String name;
	private Double salary; 
}
