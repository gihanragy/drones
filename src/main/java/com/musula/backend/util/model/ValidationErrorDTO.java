package com.musula.backend.util.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class ValidationErrorDTO implements Serializable {

    private final List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public ValidationErrorDTO() {
    }

    public void addFieldError(FieldErrorDTO fieldErrorDTO) {
        fieldErrors.add(fieldErrorDTO);
    }

    @JsonProperty("errors")
    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }

}
