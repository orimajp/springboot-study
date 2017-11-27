package com.example.correlationcheckannotation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class TopController {

	@RequestMapping("/")
	public String index(TestForm testForm) {
		return "index";
	}

	@RequestMapping(path = "/post", method = RequestMethod.POST)
	public String post(@Valid TestForm testForm, BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}
		return "result";
	}

}
