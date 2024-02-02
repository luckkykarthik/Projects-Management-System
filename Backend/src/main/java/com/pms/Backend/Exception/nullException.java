package com.pms.Backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class nullException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public nullException(String message) {
        super(message);
    }

}
