package com.hmsapi.hospital_system.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NotExitsException extends RuntimeException {
    public NotExitsException(String message) {
        super(message);
    }
}
