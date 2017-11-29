package com.example.pluginimplementationstudy.crying.impl;

import com.example.pluginimplementationstudy.animal.impl.Cat;
import com.example.pluginimplementationstudy.crying.Crying;

public class CatCrying implements Crying<Cat> {

	@Override
	public String cry(Cat cat) {
		return getMessage(cat.getName(), cat.getCry());
	}

}
