package com.example.correlationcheckannotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({TYPE,ANNOTATION_TYPE})
@Constraint(validatedBy = DateCorrelationValidator.class)
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface DateCorrelationValid {

	String message() default "終了日は開始日より過去にはできません。";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

	String startDateProperty();
	String endDateProperty();

	@Target({TYPE,ANNOTATION_TYPE})
	@Retention(RUNTIME)
	@Documented
	@interface List {
		DateCorrelationValid[] value();
	}

}
