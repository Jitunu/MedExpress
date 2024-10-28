package com.medexpress.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnswerValidator implements ConstraintValidator<ValidAnswer, String> {

    @Override
    public void initialize(ValidAnswer constraintAnnotation) {
        // Initialization code if needed (not required in this case)
    }

    @Override
    public boolean isValid(String answer, ConstraintValidatorContext context) {
        return answer != null && !answer.trim().isEmpty();
    }
}
