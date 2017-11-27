package com.example.multiprocesstest;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.logging.Logger;

@Component
public class DummyProcessor {

	private final Logger logger = Logger.getLogger(getClass().getName());

	private Random random = new Random();

	// 時間経過処理
	public void process() {
		try {
			Integer time = random.nextInt(10) + 1;
			logger.info("ウェイトタイム time=" + time);
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
