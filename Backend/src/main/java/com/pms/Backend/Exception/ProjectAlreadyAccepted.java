package com.pms.Backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class ProjectAlreadyAccepted extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ProjectAlreadyAccepted(String message) {
		super(message);
	}

}