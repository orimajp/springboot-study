package com.example.asyncexceptiontest;

import lombok.RequiredArgsConstructor;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@RequiredArgsConstructor
public class AsyncConfig extends AsyncConfigurerSupport {

	private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

	private final CustomAsyncUncaughtExceptionHandler customAsyncUncaughtExceptionHandler;

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return customAsyncUncaughtExceptionHandler;
	}

	@Override
	public Executor getAsyncExecutor() {
		return threadPoolTaskExecutor;
	}

}
