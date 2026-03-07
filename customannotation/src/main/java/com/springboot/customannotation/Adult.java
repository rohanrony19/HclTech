package com.springboot.customannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = AdultValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Adult {
	
	String message() default "Age must be 18 or above";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default{};
	
	int value() default 18;

}
