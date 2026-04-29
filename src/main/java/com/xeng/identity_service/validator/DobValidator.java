package com.xeng.identity_service.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

/**
 * @author X.e.n.g
 * @version 1.O
 * @project name: identity-service
 * @date: 29-Apr-26
 * @time: 05:18 PM
 * @package: com.xeng.identity_service.validator
 */

public class DobValidator implements ConstraintValidator<DobConstraint, LocalDate> {
    @Override
    public void initialize(DobConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
