package com.training.employeemgmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.training.employeemgmt.entity.UserDetailsEntity;

public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Integer>{
	
	public Optional<UserDetailsEntity> findByUserName(String userName);
}
