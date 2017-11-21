package com.example.jackson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestController {

	@RequestMapping("/")
	public ResponseEntity index() {
		LocalDateTime nowTime = LocalDateTime.now();
		Now now = new Now(nowTime, nowTime);
		return ResponseEntity.ok(now);
	}

}
