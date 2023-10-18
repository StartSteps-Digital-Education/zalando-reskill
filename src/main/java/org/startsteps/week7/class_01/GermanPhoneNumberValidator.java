package org.startsteps.week7.class_01;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GermanPhoneNumberValidator implements ConstraintValidator<ValidGermanPhoneNumber, String> {
    @Override
    public void initialize(ValidGermanPhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }

        String regex = "^(\\+49|0)[1-9][0-9]{9}";

        return s.matches(regex);
    }
}
