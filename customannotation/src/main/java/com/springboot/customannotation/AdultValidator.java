package com.springboot.customannotation;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AdultValidator implements ConstraintValidator<Adult, Integer>{
	private int minage;

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value==null) {
			return true;
		}
		return value>=minage;
	}

	@Override
	public void initialize(Adult constraintAnnotation) {
		this.minage = constraintAnnotation.value();
	}
	
	
}
