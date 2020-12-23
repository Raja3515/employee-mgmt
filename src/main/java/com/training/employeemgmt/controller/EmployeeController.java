package com.training.employeemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.employeemgmt.entity.Employee;
import com.training.employeemgmt.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return employees;
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/employee")
//	public Employee getEmployeeDetails(@RequestParam(value = "empId") Integer employeeId) {
//		Employee employeeDetails = employeeService.getEmployeeDetails(employeeId);
//		return employeeDetails;
//	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/employee/{empId}")
	public Employee getEmployeeDetails(@PathVariable(value = "empId") Integer employeeId) {
		Employee employeeDetails = employeeService.getEmployeeDetails(employeeId);
		return employeeDetails;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee employeeDetails = employeeService.saveEmployee(employee);
		return employeeDetails;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee")
	public Boolean deleteEmployee(@RequestParam Integer employeeId) {
		Boolean isDeleted = employeeService.deleteEmployee(employeeId);
		return isDeleted;
	}
}
