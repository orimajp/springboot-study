package com.example.multiprocesstest;

import lombok.RequiredArgsConstructor;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * https://www.qoosky.io/techs/2e9599819d
 * https://qiita.com/thrakt/items/c8f33a57636e5dcf9d48
 */
@EnableAsync
@Configuration
@RequiredArgsConstructor
public class AsyncConfig extends AsyncConfigurerSupport {

	private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return super.getAsyncUncaughtExceptionHandler();
	}

	@Override
	public Executor getAsyncExecutor() {
		return threadPoolTaskExecutor;
	}

}
