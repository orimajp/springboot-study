package com.example.asyncexceptiontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class AsyncExceptionTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncExceptionTestApplication.class, args);
	}
}
