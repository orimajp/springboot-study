package com.example.flywayh2dbmysqlmodetrouble;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GreetingService {

	private final GreetingDao greetingDao;

	public List<Greeting> getGreetingMessages() {
		return greetingDao.selectAll();
	}

}
