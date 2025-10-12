package com.cp.project_mangashop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.project_mangashop.repository.UserRepository;
import com.cp.project_mangashop.security.JwtUtil;

	@RestController
	@RequestMapping("/auth")
	public class AuthController {

	    @Autowired
	    private AuthenticationManager authManager;

	    @Autowired
	    private JwtUtil jwtUtil;

	    @Autowired
	    private UserRepository userRepo;

	    @PostMapping("/login")
	    public Map<String, String> login(@RequestBody Map<String, String> body) {
	        try {
	            String username = body.get("username");
	            String password = body.get("password");

	            Authentication authentication = authManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(username, password)
	            );

	            String token = jwtUtil.generateToken(username);
	            return Map.of("token", token);
	        } catch (AuthenticationException e) {
	            return Map.of("error", "Credenziali non valide");
	        }
	    }
	
}
