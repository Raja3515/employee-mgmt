package com.training.employeemgmt.service;

import java.util.List;

import com.training.employeemgmt.entity.Employee;

public interface EmployeeService {

	/**
	 * This method returns all the employees present in employee table
	 * 
	 * @return returns all employees 
	 */
	public List<Employee> getAllEmployees();
	
	/**
	 * This method returns all employees whose age greater than given age
	 * @param age
	 * @return returns employees with age greater than given age else empty list
	 */
	public List<Employee> getEmployeesByAge(Integer age);

	public Employee getEmployeeDetails(Integer employeeId);

	public Employee saveEmployee(Employee employee);

	public Boolean deleteEmployee(Integer employeeId);

	public Employee updateEmployee(Employee employee);

}
