package com.example.validatorinjection;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class TestValidator implements ConstraintValidator<TestConstraint, String> {

	@NonNull
	private final TestRepository testRepository;

	@Override
	public void initialize(TestConstraint constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return StringUtils.isEmpty(value) || testRepository.authenticate(value);
	}

}
