package com.musula.backend.drones.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = NotMatchValidator.class)
public @interface NotMatch {
    String[] value();

    String message() default "{Match.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}