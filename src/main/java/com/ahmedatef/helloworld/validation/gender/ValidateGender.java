package com.ahmedatef.helloworld.validation.gender;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = GenderValidator.class)
public @interface ValidateGender {
    String message() default "Gender can either be M or F.";

    // Validation groups are a way to group related constraints and apply them selectively during validation.
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
