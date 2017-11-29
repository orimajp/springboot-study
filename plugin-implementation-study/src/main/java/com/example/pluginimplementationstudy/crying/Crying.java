package com.example.pluginimplementationstudy.crying;

import com.example.pluginimplementationstudy.animal.Animal;

public interface Crying<T extends Animal> {

	default String getMessage(String name, String cry) {
		return String.format("%s は %s と鳴く。", name, cry);
	}

	String cry(T t);

}
