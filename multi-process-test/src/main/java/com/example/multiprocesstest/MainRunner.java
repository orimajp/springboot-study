package com.example.multiprocesstest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MainRunner implements CommandLineRunner {

	private final Set<Integer> idSet = ConcurrentHashMap.newKeySet();

	@Override
	public void run(String... args) throws Exception {

	}


	public void mainProcess() {
		// データ取得
		// 管理マップに追加
		// レコード再取得
		// ステータス確認
		// 処理実行(非同期)
		// 管理マップから削除


	}





}
