package com.training.employeemgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.employeemgmt.entity.Employee;
import com.training.employeemgmt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	}
}
