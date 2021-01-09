package com.training.employeemgmt.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.training.employeemgmt.service.UserDetailsServiceImpl;


@Component
//@Order(1)
public class AuthenticationFilter implements Filter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		String userId = httpServletRequest.getHeader("userid");
		String password = httpServletRequest.getHeader("password");
		if (!StringUtils.hasText(userId) || !StringUtils.hasText(password)) {
			httpServletResponse.getWriter().write("Invalid or missing headers");
			httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			return;
		}
		Boolean isAuthenticated = userDetailsServiceImpl.validateUserForAuthentication(userId, password);
		if (isAuthenticated) {
			chain.doFilter(request, response);
		} else {
			httpServletResponse.getWriter().write("Invalid User Details");
			httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
			return;
		}
	}

}
