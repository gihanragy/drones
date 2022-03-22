package com.musula.backend.drones.validator;

import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchValidator implements ConstraintValidator<Match, Object> {
    private static final SpelExpressionParser PARSER = new SpelExpressionParser();
    private String[] fields;

    @Override
    public void initialize(Match constraintAnnotation) {
        fields = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            List<Object> fieldsValues = Stream.of(fields)
                    .map(field -> PARSER.parseExpression(field).getValue(value))
                    .collect(Collectors.toList());
            return !fieldsValues.isEmpty() && fieldsValues.stream().allMatch(fieldsValues.get(0)::equals);
        } catch (NullPointerException e) {
            return false;
        }
    }
}
