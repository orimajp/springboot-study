package com.example.aoploggingtest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index () {
		return "ok";
	}

}
