package com.medexpress.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AnswerValidator.class) // Link to the custom validator class
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAnswer {

    String message() default "Answer must not be blank or null"; // Default validation message

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
