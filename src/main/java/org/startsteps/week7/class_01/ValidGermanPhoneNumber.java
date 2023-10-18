package org.startsteps.week7.class_01;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GermanPhoneNumberValidator.class)
public @interface ValidGermanPhoneNumber {
    String message() default "Invalid German phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
