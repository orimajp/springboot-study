package com.example.singleton;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TestController {

	private Logger logger = Logger.getLogger(TestController.class.getName());

	private final TestController2 testController2;

	private final TestService testService;

	private final TestReqpsitory testReqpsitory;

	private final TestBean testBean;

	private final TestConfigurable testConfigurable;

	private final MyLogicFactory myLogicFactory;

	public TestController(TestController2 testController2, TestService testService, TestReqpsitory testReqpsitory,
			TestBean testBean, TestConfigurable testConfigurable, MyLogicFactory myLogicFactory) {
		this.testController2 = testController2;
		this.testService = testService;
		this.testReqpsitory = testReqpsitory;
		this.testBean = testBean;
		this.testConfigurable = testConfigurable;
		this.myLogicFactory = myLogicFactory;
	}

	@RequestMapping("/")
	public String index() {

		TestController2 tmpTestController2 = new TestController2();
		if (testController2 == tmpTestController2) {
			logger.info("same. TestController2");
		} else {
			logger.info("diff. TestController2 " + testController2 + " / " + tmpTestController2);
		}

		TestService tmpTestService = new TestService();
		if (testService == tmpTestService) {
			logger.info("same. TestService");
		} else {
			logger.info("diff. TestService " + testService + " / " + tmpTestService);
		}

		TestReqpsitory tmpTestRepository = new TestReqpsitory();
		if (testReqpsitory == tmpTestRepository) {
			logger.info("same. TestReqpsitory");
		} else {
			logger.info("diff. TestReqpsitory " + testReqpsitory + " / " + tmpTestRepository);
		}

		TestBean tmpTestBean = new TestBean();
		if (testBean == tmpTestBean) {
			logger.info("same. TestBean");
		} else {
			logger.info("diff. TestBean " + testBean + " / " + tmpTestBean);
		}

		TestConfigurable tmpTestConfigurable = new TestConfigurable();
		if (testConfigurable == tmpTestConfigurable) {
			logger.info("same. TestConfigurable");
		} else {
			logger.info("diff. TestConfigurable " + testConfigurable + " / " + tmpTestConfigurable);
		}


		// ファクトリクラスでのインスタンス取得
		MyLogic myLogic = myLogicFactory.of();
		TestBean tmpTestBean2 = myLogic.getTestBean();
		if (testBean == tmpTestBean2) {
			logger.info("same. TestBean (ファクトリクラス利用パターン)");
		} else {
			logger.info("diff. TestBean (ファクトリクラス利用パターン) " + tmpTestBean + " / " + tmpTestBean2);
		}

		return "ok";
	}

}
