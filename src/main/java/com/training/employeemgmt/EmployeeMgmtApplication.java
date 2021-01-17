package com.training.employeemgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.training.employeemgmt.filters.AuthenticationFilter;
import com.training.employeemgmt.service.EmployeeService;
import com.training.employeemgmt.service.EmployeeServiceImpl;
import com.training.employeemgmt.service.UserDetailService;
import com.training.employeemgmt.service.UserDetailsServiceImpl;

@SpringBootApplication
public class EmployeeMgmtApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMgmtApplication.class, args);
	}
	
//	@Bean
//	public FilterRegistrationBean<AuthenticationFilter> authenticationFilter(UserDetailsServiceImpl userDetailsServiceImpl){
//		FilterRegistrationBean<AuthenticationFilter> filterRegistrationBean=new FilterRegistrationBean<>();
//		AuthenticationFilter authenticationFilter=new AuthenticationFilter();
//		authenticationFilter.setUserDetailsServiceImpl(userDetailsServiceImpl);
//		filterRegistrationBean.setFilter(authenticationFilter);
//		filterRegistrationBean.setOrder(1);
//		filterRegistrationBean.addUrlPatterns("/emp-mgmt/*");
//		return filterRegistrationBean;
//	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EmployeeMgmtApplication.class);
	}

}
