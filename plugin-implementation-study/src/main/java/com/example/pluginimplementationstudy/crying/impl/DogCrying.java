package com.example.pluginimplementationstudy.crying.impl;

import com.example.pluginimplementationstudy.animal.impl.Dog;
import com.example.pluginimplementationstudy.crying.Crying;

public class DogCrying implements Crying<Dog> {

	@Override
	public String cry(Dog dog) {
		return getMessage(dog.getName(), dog.getCry());
	}

}
