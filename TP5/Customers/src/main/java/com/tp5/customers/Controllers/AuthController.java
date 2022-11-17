package com.tp5.customers.Controllers;

import com.tp5.customers.Dtos.SignInDto;
import com.tp5.customers.Dtos.SignInResultDto;
import com.tp5.customers.Services.AuthService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
