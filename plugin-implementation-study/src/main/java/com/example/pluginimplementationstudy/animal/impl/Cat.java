package com.example.pluginimplementationstudy.animal.impl;

import com.example.pluginimplementationstudy.animal.Animal;

public class Cat implements Animal {

	@Override
	public String getName() {
		return "猫";
	}

	@Override
	public String getCry() {
		return "ニャー";
	}

}
