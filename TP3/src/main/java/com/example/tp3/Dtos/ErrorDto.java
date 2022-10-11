package com.example.tp3.Dtos;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class ErrorDto {

    private String message;

    public ErrorDto(String message) {
        super();
        this.message = message;
    }
    
    public String getMessage() {
		return message;
	}
	
}
