package sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import sales.dtos.SignInDto;
import sales.dtos.SignInResultDto;
import sales.services.AuthService;

@RestController
@Tag(name = "Servicio de autenticación", description = "Servicios de API autenticación")
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
