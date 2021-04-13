package com.vishnu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="USER_MASTER")
@Data
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="PHONE_NUMBER")
	private Integer phoneNumber;
	@Column(name="EMAIL_ID")
	private String emailId;
	@Column(name="DOB")
	private Date dob;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="STATE")
	private String state;
	@Column(name="CITY")
	private String city;
	@Column(name="ACC_STATUS")
	private String accStatus;
	@Column(name="PASSWORD")
	private String password;
}
