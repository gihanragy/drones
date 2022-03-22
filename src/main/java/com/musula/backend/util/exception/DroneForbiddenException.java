package com.musula.backend.util.exception;

import org.springframework.http.HttpStatus;

public class DroneForbiddenException extends ServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1;

    public DroneForbiddenException(String code, String message) {
        super(code, message);
        status = HttpStatus.FORBIDDEN;
    }

    public DroneForbiddenException(String code, String message, Object... args) {
        super(code, message, args);
        status = HttpStatus.FORBIDDEN;
    }

    public DroneForbiddenException(String code, Object... args) {
        super(code, args);
        status = HttpStatus.FORBIDDEN;
    }

}
