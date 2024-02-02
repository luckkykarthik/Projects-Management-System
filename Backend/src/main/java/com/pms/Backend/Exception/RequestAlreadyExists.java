package com.pms.Backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RequestAlreadyExists extends RuntimeException{
//	private static final long serialVersionUID = 1L;

	public RequestAlreadyExists(String message) {
		super(message);
	}

}
