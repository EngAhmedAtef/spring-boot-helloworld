package com.ahmedatef.helloworld.validation.country;

import com.ahmedatef.helloworld.enums.Country;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<ValidateCountry, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (Country country : Country.values())
            if (s.equals(country.getName()))
                return true;
        return false;
    }
}
