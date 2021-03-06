package com.example.multiprocesstest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ExecutorConfig {

	@Bean
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(5);
		executor.setThreadNamePrefix("DummyProcess-");
		executor.initialize();

		return executor;
	}


}
