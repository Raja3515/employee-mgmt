package com.training.employeemgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "EMPLOYEE",schema = "dbo")
@Entity
public class Employee {
	
	@Column(name = "[EMPLOYEE_ID]")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(name = "[EMPLOYEE_NAME]")
	private String employeeName;
	
	@Column(name = "[AGE]")
	private Integer age;
	
	@Column(name = "[SALARY]")
	private Float salary;
	
	@Column(name = "[ADDRESS]")
	private String address;

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

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
