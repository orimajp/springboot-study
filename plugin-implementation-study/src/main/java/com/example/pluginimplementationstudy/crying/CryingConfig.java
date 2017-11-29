package com.example.pluginimplementationstudy.crying;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CryingConfig {

	@NonNull
	private final List<Crying> cryings;

	@NonNull
	private final CryingStore cryingStore;

	@PostConstruct
	public void initializeCryingStore() {
		if (cryings == null) {
			throw new IllegalArgumentException("Crying未発見。");
		}

		for (Crying crying: cryings) {
			Type[] types = crying.getClass().getGenericInterfaces();
			Type[] actualTypeArguments = ((ParameterizedType)types[0]).getActualTypeArguments();

			final String className = actualTypeArguments[0].getTypeName();
			final Class clazz;
			try {
				clazz = Class.forName(className);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("クラスが見つかりません。class=[".concat(className).concat("]"), e);
			}
			cryingStore.registCrying(clazz, crying);
		}
	}

}
