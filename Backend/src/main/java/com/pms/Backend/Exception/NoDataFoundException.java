package com.pms.Backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoDataFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoDataFoundException(String message) {
        super(message);
    }
}
