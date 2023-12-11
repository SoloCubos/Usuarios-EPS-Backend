package com.solocubos.usuarioeps.app.usuarioeps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solocubos.usuarioeps.app.usuarioeps.DTO.LoginRequest;
import com.solocubos.usuarioeps.app.usuarioeps.DTO.LoginResponse;
import com.solocubos.usuarioeps.app.usuarioeps.jwt.JwtUtils;
import com.solocubos.usuarioeps.app.usuarioeps.service.CustomUserDetailsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    

    @Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtils jwtUtil;

    @GetMapping("/status")
    public String status(){
        return "todo bn por aqui";
    }
	 
	@PostMapping("/")
	    public ResponseEntity<?> generarToken(@RequestBody LoginRequest loginRequest) throws Exception {
		 try {
			autenticar(loginRequest.getUsername(),loginRequest.getPassword());
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
	            throw new Exception("Usuario no encontrado");
		}
		 
		 UserDetails userDetails =  this.customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
		 String token = this.jwtUtil.createToken(userDetails);
		 return ResponseEntity.ok(new LoginResponse(token));
	 }
	 
	 private void autenticar(String username,String password) throws Exception {
	        try{
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
	        }catch (BadCredentialsException e){
	            throw  new Exception("Credenciales invalidas " + e.getMessage());
	        }
	    }
}
