package com.cp.project_mangashop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cp.project_mangashop.entity.User;
import com.cp.project_mangashop.repository.UserRepository;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Utente non trovato" + username));
		
		return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().replace("ROLE_", ""))
                .build();
	}

}
