package com.example.validatorinjection;

import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

	public boolean authenticate(String value) {
		return value.equals("aa");
	}

}
