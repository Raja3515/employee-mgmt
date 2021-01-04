package com.training.employeemgmt.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopLogging {

	Logger logger = LoggerFactory.getLogger(AopLogging.class);

//	@Pointcut("execution(* com.training.employeemgmt.*.*.*(..))")
	@Pointcut("execution(* com.training.employeemgmt.*.*.*(..))")
	private void all() {
	}
	
	@Pointcut("execution(* com.training.employeemgmt.controller.*.*(..))")
	private void allControllers() {
	}
	
//	@Before("getAllEmployees()")
//	public void beforeGetAllEmployees(JoinPoint joinPoint) {
//		logger.info("********* getAllEmployees() Start *********");
//	}
	

	@Before("all()")
	public void beforeAll(JoinPoint joinPoint) {
		logger.info("********* " + joinPoint.getSignature() + " Start *********");
	}

	@AfterReturning("all()")
	public void afterAll(JoinPoint joinPoint) {
		logger.info("********* " + joinPoint.getSignature() + " end *********");
	}

	@AfterThrowing(pointcut = "allControllers()",throwing = "exception")
	public void afterThrowingException(JoinPoint joinPoint, Exception exception) {
		logger.error("********* Exception occured in " + joinPoint.getSignature() + " *********");
		logger.error(exception.getMessage(), exception);
	}
}
