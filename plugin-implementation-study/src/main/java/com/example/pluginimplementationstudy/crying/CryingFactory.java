package com.example.pluginimplementationstudy.crying;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CryingFactory {

	@NonNull
	private final CryingStore cryingStore;

	public  Crying getCrying(Class clazz) {
		final Crying crying = cryingStore.getCrying(clazz);
		if (crying == null) {
			throw new IllegalArgumentException(clazz.toString() + "は鳴きません。");
		}
		return crying;
	}

}
