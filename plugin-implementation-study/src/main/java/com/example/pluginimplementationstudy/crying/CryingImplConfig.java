package com.example.pluginimplementationstudy.crying;

import com.example.pluginimplementationstudy.crying.impl.CatCrying;
import com.example.pluginimplementationstudy.crying.impl.DogCrying;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CryingImplConfig {

	@Bean
	public CatCrying catCrying() {
		return new CatCrying();
	}

	@Bean
	public DogCrying dogCrying() {
		return new DogCrying();
	}

}
