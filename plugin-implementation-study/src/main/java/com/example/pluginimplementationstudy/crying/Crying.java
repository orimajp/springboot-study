package com.example.pluginimplementationstudy.crying;

import com.example.pluginimplementationstudy.animal.Animal;

public interface Crying<T extends Animal> {

	default String getMessage(String name, String cry) {
		return String.format("%s は %s と鳴く。", name, cry);
	}

	String cry(T t);

	// この例では、以下のようにすれば実装クラスでのメソッド実装は必須ではなくなるが...
/*	default String cry(T t) {
		return getMessage(t.getName(), t.getCry());
	}*/

}
