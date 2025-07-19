package com.hmsapi.hospital_system.exception;

import com.hmsapi.hospital_system.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler{


    @ExceptionHandler(AlreadyExitsException.class)
    public ResponseEntity<ExceptionResponseDTO> categoriesExitsGlobalExceptionHandler(AlreadyExitsException exception, WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.CONFLICT.toString(),
                exception.getMessage(),
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);
    }


    @ExceptionHandler(NotExitsException.class)
    public ResponseEntity<ExceptionResponseDTO> categoriesExitsGlobalExceptionHandler(NotExitsException exception, WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.CONFLICT.toString(),
                exception.getMessage(),
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);
    }
}
