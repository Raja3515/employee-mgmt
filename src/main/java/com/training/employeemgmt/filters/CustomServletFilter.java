package com.training.employeemgmt.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

public class CustomServletFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		HttpServletResponse httpServletResponse=(HttpServletResponse) response;
		String userId = httpServletRequest.getHeader("user-id");
		if(StringUtils.hasText(userId)) {
			httpServletResponse.getWriter().write("Invalid UserId");
			httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			return;
		}
		chain.doFilter(request, response);
	}

}
