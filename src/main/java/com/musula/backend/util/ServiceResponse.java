package com.musula.backend.util;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.musula.backend.util.model.ValidationErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse {
    private String details;
    private ValidationErrorDTO validationErrorDTO;
    private String code;

    @JsonProperty("details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @JsonProperty("validation")
    public ValidationErrorDTO getValidationErrorDTO() {
        return validationErrorDTO;
    }

    public void setValidationErrorDTO(ValidationErrorDTO validationErrorDTO) {
        this.validationErrorDTO = validationErrorDTO;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
