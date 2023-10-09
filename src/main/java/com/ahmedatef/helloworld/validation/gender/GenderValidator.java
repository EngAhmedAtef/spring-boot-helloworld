package com.ahmedatef.helloworld.validation.gender;

import com.ahmedatef.helloworld.enums.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<ValidateGender, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.equals(Gender.F.toString()) || s.equals(Gender.M.toString());
    }
}
