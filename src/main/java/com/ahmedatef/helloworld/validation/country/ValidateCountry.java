package com.ahmedatef.helloworld.validation.country;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CountryValidator.class)
public @interface ValidateCountry {

    String message() default "Invalid country. Available countries are; Egypt, Saudi Arabia, United Arab Emirates and Qatar.";

    // Validation groups are a way to group related constraints and apply them selectively during validation.
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
