package com.userprofile.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NumberValidator.class)
public @interface NumberValidations {

	public String message() default "must be a valid 10 digit mobile number";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};

}
