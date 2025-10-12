package com.cp.project_mangashop.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.project_mangashop.dto.AuthResponse;
import com.cp.project_mangashop.dto.user.UserDTO;
import com.cp.project_mangashop.dto.user.UserDTOMapper;
import com.cp.project_mangashop.entity.User;
import com.cp.project_mangashop.security.JwtUtil;
import com.cp.project_mangashop.service.interfaces.UserService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserService userService;
	
	// API ADMIN
	
	@GetMapping(path = "/admin/user/all")
	public ResponseEntity<?> getAll() {
		List<User> users = userService.getAllUsers();
		
		if(users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<UserDTO> usersDTO = users.stream()
				.map(user -> UserDTOMapper.UserToDTO(user))
				.toList();
		
		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
	}
	
	@GetMapping(path = "/admin/user/{id_user}")
	public ResponseEntity<?> getUser(@PathVariable int id_user) {
		User user = userService.getUser(id_user);
		UserDTO userDTO = UserDTOMapper.UserToDTO(user);
		
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
	
	
	
	// API PUBBLICHE
	
	@PostMapping(path = "/public/user/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
		String username = credentials.get("username");
        String password = credentials.get("password");
		
		try {
			Optional<User> user = userService.findByUsername(username);
            if(!user.isPresent()) {
            	return new ResponseEntity<>("Utente non registrato", HttpStatus.BAD_REQUEST);
            }

            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            
            String token = jwtUtil.generateToken(username);

            return new ResponseEntity<>(new AuthResponse(user.get().getUsername(), user.get().getRole(), token), HttpStatus.OK);

		}
            
            catch (AuthenticationException e) {
            return new ResponseEntity<>("Credenziali errate.", HttpStatus.BAD_REQUEST);
        }
    }
	
	@PostMapping(path = "/public/user/register")
	public ResponseEntity<?> insertUser(@RequestBody User user) {
		boolean created = userService.insertUser(user);
		
		if(!created) {
			return new ResponseEntity<>("Utente già registrato", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	// TEST
	
	 @GetMapping("/profile")
	    public Map<String, String> profile() {
	        return Map.of("message", "Accesso riuscito! Sei autenticato con JWT 🎉");
	    }
	
}
