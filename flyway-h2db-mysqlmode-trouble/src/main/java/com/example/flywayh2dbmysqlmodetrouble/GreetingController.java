package com.example.flywayh2dbmysqlmodetrouble;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

	private final GreetingService greetingService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity greetingMessages() {
		return ResponseEntity.ok(greetingService.getGreetingMessages());
	}

}
