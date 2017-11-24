package com.example.seversenteventsample;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class GreetingMessageSender {

	@Async
	public void send(SseEmitter emitter) throws IOException, InterruptedException {
		int i = 1;

		emitter.send(SseEmitter.event().id(String.valueOf(i++)).data("Good Morning !"));

		TimeUnit.SECONDS.sleep(1);

		emitter.send(SseEmitter.event().id(String.valueOf(i++)).data("Hello !"));

		TimeUnit.SECONDS.sleep(1);

		emitter.send(SseEmitter.event().id(String.valueOf(i)).data("Good night !"));

		TimeUnit.SECONDS.sleep(1);

		emitter.complete();
	}

}
