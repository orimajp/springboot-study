package com.example.correlationcheckannotation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCorrelationValidator implements ConstraintValidator<DateCorrelationValid, Object> {

	private String startDateProperty;
	private String endDateProperty;
	private String message;

	@Override
	public void initialize(DateCorrelationValid constraintAnnotation) {
		startDateProperty = constraintAnnotation.startDateProperty();
		endDateProperty = constraintAnnotation.endDateProperty();
		message = constraintAnnotation.message();
	}

	final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		final BeanWrapper beanWrapper = new BeanWrapperImpl(value);
		final String start = (String)beanWrapper.getPropertyValue(startDateProperty);
		final String end = (String)beanWrapper.getPropertyValue(endDateProperty);
		final LocalDate startDate;
		final LocalDate endDate;
		try {
			startDate = LocalDate.parse(start, dtf);
			endDate = LocalDate.parse(end, dtf);
		} catch (Exception e) {
			return true;
		}

		if (startDate.equals(endDate) || startDate.isBefore(endDate)) {
			return true;
		}

		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(message)
				.addPropertyNode(endDateProperty)
				.addConstraintViolation();

		return false;
	}
}
