package com.training.employeemgmt.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.employeemgmt.dto.ApiResponse;
import com.training.employeemgmt.entity.UserDetailsEntity;
import com.training.employeemgmt.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailService {
	
	Logger logger=LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public Boolean validateUserForAuthentication(String userName, String password) {
		Optional<UserDetailsEntity> optional = userDetailsRepository.findByUserName(userName);
		if(optional.isPresent()) {			
			if (optional.get().getPassword().equals(password)) {
				return true;
			}else {
				logger.error("User detail found but password doesn't match");;
			}
		}else {
			logger.warn("User details not found");
		}
		return false;
	}

	public Boolean validateUserForAuthentication(String ssoToken) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ApiResponse> entity = restTemplate.getForEntity("sample url", ApiResponse.class);
		ApiResponse apiResponse = entity.getBody();
		return null;
	}
}
