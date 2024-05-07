package com.userprofile.annotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumberValidator implements ConstraintValidator<NumberValidations, Long> {

	@Override
	public boolean isValid(Long userNumber, ConstraintValidatorContext context) {

		if (userNumber == null) {

			return false;
		} else {
			String userNumber1 = userNumber.toString();
			Pattern p = Pattern.compile("^\\d{10}$");
			Matcher m = p.matcher(userNumber1);

			return m.matches();
		}

	}
}
