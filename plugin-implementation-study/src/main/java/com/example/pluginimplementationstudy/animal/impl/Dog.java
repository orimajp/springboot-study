package com.example.pluginimplementationstudy.animal.impl;

import com.example.pluginimplementationstudy.animal.Animal;

public class Dog implements Animal {

	@Override
	public String getName() {
		return "犬";
	}

	@Override
	public String getCry() {
		return "ワン";
	}

}
