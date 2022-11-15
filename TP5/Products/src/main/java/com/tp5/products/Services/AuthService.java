package com.tp5.products.Services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import products.dtos.SignInDto;
import products.dtos.SignInResultDto;

@Service
public class AuthService {

	public SignInResultDto getJwtToken(SignInDto signInDto) {
		if (!signInDto.user.equals("usuariointerno") || !signInDto.password.equals("usuariointerno"))
			return new SignInResultDto("", "User name or password is incorrect. Maybe 'usuariointerno' for both? ;)");
		
		String token = createToken(signInDto.user);
		
		return new SignInResultDto(token, "");
	}
	
	public String getInternalJwtToken() {
		return createToken("internal");
	}
	
	private String createToken(String user) {
		String secretKey = "7639b3c8-68cb-42fa-80b7-d159a680c7f2";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("User");
		String token = Jwts.builder()
				.setSubject(user)
				.claim("roles", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
		return token;
	}
	
}
