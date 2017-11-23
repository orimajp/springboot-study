package com.example.singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

	@Bean
	public TestBean testBean() {
		return new TestBean();
	}

	@Bean
	public TestConfigurable testConfigurable() {
		return new TestConfigurable();
	}

}
