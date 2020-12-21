package com.training.employeemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.employeemgmt.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
