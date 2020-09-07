package com.cisco.prj.entity;

import com.cisco.prj.annotation.Column;
import com.cisco.prj.annotation.Table;

@Table(name="emps")
public class Employee {
	private String email;
	
	private String firstName;

	@Column(name="EMP_EMAIL")
	public String getEmail() {
		return email;
	}
	@Column(name="FIRST_NAME", type="VARCHAr(50)")
	public String getFirstName() {
		return firstName;
	}
	
	
}
