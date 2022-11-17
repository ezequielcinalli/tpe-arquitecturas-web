package com.tp5.products.Controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp5.products.Dtos.SignInDto;
import com.tp5.products.Dtos.SignInResultDto;
import com.tp5.products.Services.AuthService;

@RestController
@Api(tags = "auth", description = "Servicio de autenticación")
@RequestMapping("auth")
public class AuthController {

	@Autowired
    private final AuthService service;
	
	public AuthController(AuthService service){
       this.service = service; 
    }
	
	@PostMapping("/sign-in")
	public SignInResultDto signIn(@RequestBody SignInDto signInDto) {
		return service.getJwtToken(signInDto);
	}
	
}
