package com.example.aoploggingtest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggerConfig {

	private final Logger logger = Logger.getLogger(getClass().getName());

	@Before("execution(* com.example.aoploggingtest.*.*(..))")
	public void invokeBefore(JoinPoint joinPoint) {
		logger.info(String.format("START **** %s.%s", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName()));
	}

	@After("execution(* com.example.aoploggingtest.*.*(..))")
	public void invokeAfter(JoinPoint joinPoint) {
		logger.info(String.format("END   **** %s.%s", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName()));
	}

}
