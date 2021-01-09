package com.training.employeemgmt.service;

public interface UserDetailService {

	/**
	 * Validate given user details
	 * 
	 * @param userName
	 * @param password
	 * @return returns true if details are valid else returns false
	 */
	public Boolean validateUserForAuthentication(String userName, String password);
}
