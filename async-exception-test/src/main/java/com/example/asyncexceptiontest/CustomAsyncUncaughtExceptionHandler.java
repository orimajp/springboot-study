package com.example.asyncexceptiontest;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/*
 * https://www.concretepage.com/spring-4/spring-4-async-exception-handling-with-asyncuncaughtexceptionhandler
 */
public class CustomAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

	private final Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {
		logger.info("ex:" + ex);
		logger.info("method:" + method);

		for (Object obj: params) {
			logger.info("param:" + obj);
		}
	}

}
