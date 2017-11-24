package com.example.seversenteventsample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Controller
public class TopController {

	private final GreetingMessageSender greetingMessageSender;

	public TopController(GreetingMessageSender greetingMessageSender) {
		this.greetingMessageSender = greetingMessageSender;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(path = "/greeting", method = RequestMethod.GET)
	public SseEmitter greeting() throws IOException, InterruptedException {
		final SseEmitter emitter = new SseEmitter();
		greetingMessageSender.send(emitter);
		return emitter;
	}

}
