package com.training.employeemgmt.service;

import java.util.List;

import com.training.employeemgmt.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeDetails(Integer employeeId);
	
	public Employee saveEmployee(Employee employee);
	
	public Boolean deleteEmployee(Integer employeeId);
	
	public Employee updateEmployee(Employee employee);

}
