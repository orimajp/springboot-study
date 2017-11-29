package com.example.pluginimplementationstudy;

import com.example.pluginimplementationstudy.animal.Animal;
import com.example.pluginimplementationstudy.animal.impl.Cat;
import com.example.pluginimplementationstudy.animal.impl.Dog;
import com.example.pluginimplementationstudy.crying.CryingFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TopController {

	private final CryingFactory cryingFactory;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity index() throws IllegalAccessException, InstantiationException {

		final Class[] classes = {Cat.class, Dog.class};

		final List<Message> messages = new ArrayList<>();
		for (Class clazz: classes) {
			final Animal animal= (Animal)clazz.newInstance();
			messages.add(new Message(cryingFactory.getCrying(clazz).cry(animal)));
		}

		return ResponseEntity.ok(messages);
	}

}
