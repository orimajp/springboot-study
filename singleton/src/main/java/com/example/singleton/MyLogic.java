package com.example.singleton;

public class MyLogic {

	private final TestBean testBean;

	public MyLogic(TestBean testBean) {
		this.testBean = testBean;
	}

	public TestBean getTestBean() {
		return testBean;
	}

}
