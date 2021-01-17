package com.training.employeemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.employeemgmt.entity.UserDetailsEntity;
import com.training.employeemgmt.service.UserDetailService;

@RestController
@RequestMapping("/usr-mgmt")
public class UserController {

	@Autowired
	private UserDetailService userDetailService;

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ResponseEntity<List<UserDetailsEntity>> getAllUsers() {
		List<UserDetailsEntity> users = userDetailService.getAllUsers();
		return new ResponseEntity<List<UserDetailsEntity>>(users, HttpStatus.OK);
	}
}
