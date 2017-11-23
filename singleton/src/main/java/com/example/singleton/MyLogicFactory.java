package com.example.singleton;

import org.springframework.stereotype.Component;

@Component
public class MyLogicFactory {

	private final TestBean testBean;

	public MyLogicFactory(TestBean testBean) {
		this.testBean = testBean;
	}

	public MyLogic of() {
		return new MyLogic(testBean);
	}

}
