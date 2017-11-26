package com.example.asyncexceptiontest;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class MainRunner implements CommandLineRunner {

	private final Logger logger = Logger.getLogger(getClass().getName());

	private final AsyncTask asyncTask;

	@Override
	public void run(String... args) throws Exception {
		final Integer id = 10;
		final Dummy dummy = new Dummy(20, "test");

		logger.info("不正値エラー確認起動 開始");

		asyncTask.exceptionProcess(id, dummy);

		logger.info("不正値エラー確認起動 終了");

		Thread.sleep(2000);

		try {
			logger.info("多重起動エラー確認起動 開始");
			int i = 0;
			while (i < 10) {
				i++;
				logger.info("起動 " + i + " 回目");
				asyncTask.process(i, dummy);
			}
		} catch (RejectedExecutionException e) {
			logger.warning("多重起動エラーです。");
		} finally {
			logger.info("多重起動エラー確認起動 終了");
		}

	}

}
