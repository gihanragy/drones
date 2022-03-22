package com.musula.backend.util.exception;

import org.springframework.http.HttpStatus;

public class DroneBadRequestException extends ServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1;

    public DroneBadRequestException(String code, String message) {
        super(code, message);
        status = HttpStatus.BAD_REQUEST;
    }

    public DroneBadRequestException(String code, String message, Object... args) {
        super(code, message, args);
        status = HttpStatus.BAD_REQUEST;
    }

    public DroneBadRequestException(String code, Object... args) {
        super(code, args);
        status = HttpStatus.BAD_REQUEST;
    }
}
