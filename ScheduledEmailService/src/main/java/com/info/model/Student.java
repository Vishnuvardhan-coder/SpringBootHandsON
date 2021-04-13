package com.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
public class Student {

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sbranch=" + sbranch + ", smail=" + smail + "]";
	}

	@Id
	private Integer sid;

	@Column
	private String sname;

	@Column
	private String sbranch;

	@Column
	private String smail;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSbranch() {
		return sbranch;
	}

	public void setSbranch(String sbranch) {
		this.sbranch = sbranch;
	}

	public String getSmail() {
		return smail;
	}

	public void setSmail(String smail) {
		this.smail = smail;
	}

}
