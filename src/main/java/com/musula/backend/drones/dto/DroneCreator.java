package com.musula.backend.drones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


/**
 * The DTO Class User.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DroneCreator {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private Boolean twoFactorEnabled;
    private String token;


}
