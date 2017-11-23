package com.example.validatorinjection;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class TestForm {

	@NotEmpty(message = "入力必須です。")
	@TestConstraint
	private String test;

}
