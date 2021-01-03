package com.training.employeemgmt.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class UpdateEmployeeModel {
	
//	@NotNull
//	@NotEmpty
//	@Range
//	@Pattern
	@Min(value = 1,message = "Min value should be 1")
	@Max(value = 10, message=" Max 10 allowed")
	private Integer employeeId;
	private String employeeName;
	@Max(value = 100, message=" Age should be Max 100")
	private Integer age;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
