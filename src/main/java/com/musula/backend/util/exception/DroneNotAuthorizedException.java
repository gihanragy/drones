package com.musula.backend.util.exception;

import org.springframework.http.HttpStatus;

public class DroneNotAuthorizedException extends ServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1;

    public DroneNotAuthorizedException(String code, String message) {
        super(code, message);
        status = HttpStatus.UNAUTHORIZED;
    }

    public DroneNotAuthorizedException(String code, String message, Object... args) {
        super(code, message, args);
        status = HttpStatus.UNAUTHORIZED;
    }

    public DroneNotAuthorizedException(String code, Object... args) {
        super(code, args);
        status = HttpStatus.UNAUTHORIZED;
    }

}
