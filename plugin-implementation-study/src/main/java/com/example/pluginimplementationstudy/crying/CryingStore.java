package com.example.pluginimplementationstudy.crying;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CryingStore {

	private final Map<Class, Crying> cryingMap = new HashMap<>();

	public void registCrying(Class clazz, Crying crying) {
		cryingMap.put(clazz, crying);
	}

	public Crying getCrying(Class clazz) {
		return cryingMap.get(clazz);
	}

}
