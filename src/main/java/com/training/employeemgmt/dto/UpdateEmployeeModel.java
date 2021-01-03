package com.training.employeemgmt.dto;

import javax.validation.constraints.Min;

public class UpdateEmployeeModel {
	@Min(value = 1,message = "Invalid employeeId")
	private Integer employeeId;
	private String employeeName;
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
