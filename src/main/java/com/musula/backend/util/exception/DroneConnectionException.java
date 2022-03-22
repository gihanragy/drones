package com.musula.backend.util.exception;

import org.springframework.http.HttpStatus;

public class DroneConnectionException extends ServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1;

    public DroneConnectionException(String code, String message) {
        super(code, message);
        status = HttpStatus.NOT_FOUND;
    }

    public DroneConnectionException(String code, String message, Object... args) {
        super(code, message, args);
        status = HttpStatus.NOT_FOUND;
    }

    public DroneConnectionException(String code, Object... args) {
        super(code, args);
        status = HttpStatus.NOT_FOUND;
    }
}
