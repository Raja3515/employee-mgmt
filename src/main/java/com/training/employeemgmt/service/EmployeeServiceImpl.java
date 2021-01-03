package com.training.employeemgmt.service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.employeemgmt.dto.EmployeeModel;
import com.training.employeemgmt.dto.UpdateEmployeeModel;
import com.training.employeemgmt.entity.Employee;
import com.training.employeemgmt.exception.CustomException;
import com.training.employeemgmt.repository.EmployeeRepository;
import com.training.employeemgmt.utils.AppErrors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> employeeModels=new ArrayList<EmployeeModel>();
		List<Employee> employeeEntities = employeeRepository.findAll();
		//Entity to DTO conversion
		for(Employee employee:employeeEntities) {
			EmployeeModel employeeModel=new EmployeeModel();
//			employeeModel.setEmployeeId(employee.getEmployeeId());
//			employeeModel.setEmployeeName(employee.getEmployeeName());
			
			BeanUtils.copyProperties(employee, employeeModel);
			employeeModels.add(employeeModel);
		}
		
		
		return employeeModels;
	}

	@Override
	public Employee getEmployeeDetails(Integer employeeId) {
		if(employeeId==null || employeeId<=0) {
			throw new CustomException(AppErrors.INVALID_EMPLOYEE_DETAILS);
		}
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	@Override
	public Boolean deleteEmployee(Integer employeeId) {
//		Employee employee=new Employee();
		employeeRepository.deleteById(employeeId);
		return true;
	}

	@Override
	public Boolean updateEmployee(UpdateEmployeeModel updateEmployeeModel) {
		//Validate EmployeeId
		Employee updatedEmployee=null;
		Optional<Employee> optional = employeeRepository.findById(updateEmployeeModel.getEmployeeId());
		if(optional.isPresent()) {
			Employee employee = optional.get();
			employee.setEmployeeName(updateEmployeeModel.getEmployeeName());
			employee.setAge(updateEmployeeModel.getAge());
			updatedEmployee = employeeRepository.save(employee);
			return true;
		}else {
			throw new CustomException(AppErrors.INVALID_EMPLOYEE_DETAILS);
		}
//		return false;
	}

	@Override
	public List<Employee> getEmployeesByAge(Integer age) {		
		return employeeRepository.getEmployeesByAge(age);
	}
}
