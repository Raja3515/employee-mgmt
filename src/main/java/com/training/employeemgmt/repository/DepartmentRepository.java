package com.training.employeemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.employeemgmt.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
