package com.training.employeemgmt.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.training.employeemgmt.service.UserDetailsServiceImpl;

@Component
@Order(2)
public class AuthorizationFilter implements Filter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		try {
			String userName = httpServletRequest.getHeader("user-name");
			if (!StringUtils.hasText(userName)) {
				httpServletResponse.getWriter().write("Invalid or missing headers");
				httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
				return;
			}
			String requestURI = httpServletRequest.getRequestURI();
			Boolean isAuthorized = userDetailsServiceImpl.validateUserForAuthorization(userName,requestURI);
			if (isAuthorized) {
				chain.doFilter(request, response);
			} else {
				httpServletResponse.getWriter().write("This action is forbidden for user");
				httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
				return;
			}
		}catch (Exception exception) {
			logger.error("Exception occured in Authorization filter", exception);
			httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return;
		}
		
	}

}
