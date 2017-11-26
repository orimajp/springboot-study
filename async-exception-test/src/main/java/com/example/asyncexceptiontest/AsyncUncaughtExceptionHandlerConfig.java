package com.example.asyncexceptiontest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsyncUncaughtExceptionHandlerConfig {

	@Bean
	public CustomAsyncUncaughtExceptionHandler customAsyncUncaughtExceptionHandler() {
		return new CustomAsyncUncaughtExceptionHandler();
	}

}
