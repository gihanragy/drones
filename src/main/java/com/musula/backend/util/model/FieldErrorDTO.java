package com.musula.backend.util.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorDTO {

    private String field;
    private String code;
    private String message;
    private Object rejectedValue;

    FieldErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("field")
    public String getField() {
        return field;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("rejectedValue")
    public Object getRejectedValue() {
        return rejectedValue;
    }

}