package com.example.multiprocesstest;

import lombok.RequiredArgsConstructor;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ProcessService {

	private final Logger logger = Logger.getLogger(getClass().getName());

	private final ProcessStatusDao processStatusDao;

	private final DummyProcessor dummyProcessor;

	public ProcessStatus getProcessStatus(Integer id) {
		return processStatusDao.selectById(id);
	}

	public List<ProcessStatus> getProcessStatusList() {
		return processStatusDao.selectAll();
	}

	// 非同期処理起動
	// 多重怒張かエラー発生時、マップより削除
	public boolean executeAsyncTask(Integer id, Set<Integer> idSet) {
		try {
			processAsyncTask(id, idSet);
			return true;
		} catch (TaskRejectedException e) {
			// キューサイズ超過
			logger.info("キューサイズ超過 id=" + id);
			idSet.remove(id);
		}
		return false;
	}


	// 非同期処理
	// トランザクション処理呼び出し
	// トランザクション処理終了時、マップより削除

	/**
	 * 非同期処理
	 *
	 * @param id ID
	 * @param idSet IDセット
	 */
	@Async
	public void processAsyncTask(Integer id, Set<Integer> idSet) {
		try {
			logger.info("非同期処理開始: id=" + id);
			processTransactionTask(id);
		} catch (Exception e) {
			logger.warning("トランザクション例外: id=" + id + " exception=" + e);
			throw e;
		} finally {
			idSet.remove(id);
			logger.info("非同期処理終了: id=" + id);
		}
	}

	/**
	 * メイントランザクション処理
	 *
	 * @param id ID
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void processTransactionTask(Integer id) {
		dummyProcessor.process();

		final ProcessStatus processStatus = processStatusDao.selectById(id);
		processStatus.setComplate(true);
		processStatusDao.update(processStatus);
	}

}
