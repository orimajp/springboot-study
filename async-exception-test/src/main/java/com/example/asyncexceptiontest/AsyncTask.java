package com.example.asyncexceptiontest;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AsyncTask {

	final Logger logger = Logger.getLogger(getClass().getName());

	@Async
	public void process(Integer id, Dummy dummy) {
		try {
			logger.info("非同期起動 id=" + id);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Async
	public void exceptionProcess(Integer id, Dummy dummy) {
		if (id != 1) {
			throw new IllegalArgumentException("不正値エラー");
		}
	}

}
