package com.training.employeemgmt.service;

import java.util.List;

import com.training.employeemgmt.entity.UserDetailsEntity;

public interface UserDetailService {

	/**
	 * Validate given user details
	 * 
	 * @param userName
	 * @param password
	 * @return returns true if details are valid else returns false
	 */
	public Boolean validateUserForAuthentication(String userName, String password);

	/**
	 * This method validates user access for the requested uri
	 * 
	 * @param userName
	 * @param roleId
	 * @return returns true if user has is authorized else returns false
	 */
	public Boolean validateUserForAuthorization(String userName, String apis);

	/**
	 * Return all the users
	 * 
	 * @return returns all users available in DB
	 */
	public List<UserDetailsEntity> getAllUsers();
}
