package com.training.employeemgmt.filters;

import java.io.IOException;
import java.util.StringTokenizer;

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
import com.training.employeemgmt.utils.AppUtils;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	

	public void setUserDetailsServiceImpl(UserDetailsServiceImpl userDetailsServiceImpl) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}

	Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		try {
			// simple authentication
			String userName = httpServletRequest.getHeader("user-name");
			String password = httpServletRequest.getHeader("password");
			
			//Basic Auth
//			this.setBasicAuthAttributes(httpServletRequest, httpServletResponse);
//			String userName = (String) httpServletRequest.getAttribute("user-name");
//			String password = (String) httpServletRequest.getAttribute("password");
			
			
			if (!StringUtils.hasText(userName) || !StringUtils.hasText(password)) {
				httpServletResponse.getWriter().write("Invalid or missing headers");
				httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
				return;
			}
			Boolean isAuthenticated = userDetailsServiceImpl.validateUserForAuthentication(userName, password);
			if (isAuthenticated) {
				chain.doFilter(request, response);
			} else {
				httpServletResponse.getWriter().write("Invalid User Details");
				httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
				return;
			}
		} catch (Exception exception) {
			logger.error("Exception occured in Authentication filter", exception);
			httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return;
		}
	}

	private void setBasicAuthAttributes(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		// basic auth
		String authorizationHeader = httpServletRequest.getHeader("Authorization");
		StringTokenizer st = new StringTokenizer(authorizationHeader);
		if (st.hasMoreTokens()) {
			String authType = st.nextToken();
			if (authType.equalsIgnoreCase("Basic")) {
				String decodedValue = AppUtils.decodeBase64(st.nextToken());
				String[] split = decodedValue.split(":");
				httpServletRequest.setAttribute("user-name", split[0]);
				httpServletRequest.setAttribute("password", split[1]);
			}
		}
	}

}
