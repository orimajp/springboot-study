package com.example.seversenteventsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SeverSentEventSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeverSentEventSampleApplication.class, args);
	}
}
