package com.training.employeemgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.employeemgmt.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public static final String GET_EMPLOYEES_BY_AGE_QUERY="select e from Employee e where e.age>:age1";
	
	
	@Query(value = GET_EMPLOYEES_BY_AGE_QUERY) // HQL
//	@Query(value = "select e from employee e where e.age>:age",nativeQuery = true) //Native Query
//	@Query(name = "raja")//Named queries
	public List<Employee> getEmployeesByAge(@Param(value = "age1") Integer age);
	
//	@Query(value = "select e from Employee e where e.address.country=:country")
//	public List<Employee> getEmployeesByCountry(String countryName);

}
