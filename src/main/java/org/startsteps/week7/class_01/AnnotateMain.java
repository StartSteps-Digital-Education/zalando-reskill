package org.startsteps.week7.class_01;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.startsteps.week7.class_01.CollectIt;

public class AnnotateMain {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        CollectIt entity = new CollectIt();
        entity.setPhoneNumber("01234567890");

        var violations = validator.validate(entity);

        if (violations.isEmpty()) {
            System.out.println("Phone number is valid.");
        } else {
            System.out.println("Validation errors:");
            for (var violation : violations) {
                System.out.println(violation.getMessage());
            }
        }
    }
}
