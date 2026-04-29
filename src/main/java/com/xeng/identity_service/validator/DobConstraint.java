package com.xeng.identity_service.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD}) // chỉ muốn apply 1 biến trong object thôi thì để là field thôi
@Retention(RetentionPolicy.RUNTIME) // là annotation sẽ được xử lý lúc nào
@Constraint(validatedBy = {})

public @interface DobConstraint {
    String message() default "Invalid date of birth";

    int min();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
