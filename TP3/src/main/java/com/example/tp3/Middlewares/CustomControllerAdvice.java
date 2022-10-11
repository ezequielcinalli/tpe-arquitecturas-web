package com.example.tp3.Middlewares;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.tp3.Dtos.ErrorDto;

@RestControllerAdvice
class CustomControllerAdvice {
	
	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleEntityNotFoundException(EntityNotFoundException e) {
		e.printStackTrace();
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<ErrorDto>(
            new ErrorDto(e.getMessage()),
            status
        );
    }
	
}