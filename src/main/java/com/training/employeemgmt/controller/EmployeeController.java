package com.training.employeemgmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.employeemgmt.entity.Employee;
import com.training.employeemgmt.service.EmployeeService;

@RestController
//@RequestMapping("/emp-mgmt")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	@GetMapping("/employees")
	@RequestMapping(method = RequestMethod.GET, value = "/employees")
//	public List<Employee> getAllEmployees(@RequestHeader("User-Id") String userId) {
	public List<Employee> getAllEmployees(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
//		httpServletResponse.setHeader("test", "test Value");
//		String header = httpServletRequest.getHeader("User-Id");
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
	
//	@DeleteMapping(value = "/employee")
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee")
	public Boolean deleteEmployee(@RequestParam Integer employeeId) {
		Boolean isDeleted = employeeService.deleteEmployee(employeeId);
		return isDeleted;
	}
	
//	@PostMapping(value = "/employee")
	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee employeeDetails = employeeService.saveEmployee(employee);
		return employeeDetails;
	}
	
//	@PutMapping(value = "/employee")
	@RequestMapping(method = RequestMethod.PUT, value = "/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

}
