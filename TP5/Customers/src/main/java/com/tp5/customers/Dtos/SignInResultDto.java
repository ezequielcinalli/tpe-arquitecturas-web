package com.tp5.customers.Dtos;

public class SignInResultDto {

	public String token;
	
	public String error;

	public SignInResultDto(String token, String error) {
		super();
		this.token = token;
		this.error = error;
	}
	
}
