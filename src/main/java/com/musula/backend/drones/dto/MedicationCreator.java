package com.musula.backend.drones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.musula.backend.constant.AppConstants;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class MedicationCreator {
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = AppConstants.INVALID_MEDICATION_NAME)
    @NotBlank(message = AppConstants.NOT_BLANCK_MEDICATION_NAME)
    private String name;

    @Pattern(regexp = "^[A-Z0-9_]*$", message = AppConstants.INVALID_MEDICATION_CODE)
    @NotBlank(message = AppConstants.NOT_BLANCK_MEDICATION_CODE)
    private String code;

    @Positive(message = AppConstants.WEIGHT_RANGE_ERROR_MESSAGE)
    @Max(value = 500, message = AppConstants.WEIGHT_RANGE_ERROR_MESSAGE)
    private float weight;

    private MultipartFile file;

}
