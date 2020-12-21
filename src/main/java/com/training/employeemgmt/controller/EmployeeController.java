package com.training.employeemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.employeemgmt.entity.Employee;
import com.training.employeemgmt.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/employees")
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return employees;
	}

}
