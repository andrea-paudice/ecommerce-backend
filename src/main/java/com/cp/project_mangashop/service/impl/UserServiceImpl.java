package com.cp.project_mangashop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cp.project_mangashop.dto.user.UserDTO;
import com.cp.project_mangashop.dto.user.UserDTOMapper;
import com.cp.project_mangashop.entity.User;
import com.cp.project_mangashop.repository.UserRepository;
import com.cp.project_mangashop.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public User getUser(int id_user) {
		User user = userRepo.findById(id_user)
				.orElseThrow(() -> new RuntimeException("Utente non trovato"));
		
		return user;
	}

	@Override
	public boolean insertUser(User user) {
		if(userRepo.findById(user.getUserId()).isPresent()) {
			return false;
		}
		
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		return true;
		
	}

	@Override
	public void updateUser(User user) {
		userRepo.save(user);
		
	}

	@Override
	public void deleteUser(int id_user) {
		userRepo.deleteById(id_user);
		
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public boolean login(User user) {
		Optional<User> dbUser = userRepo.findByUsername(user.getUsername());
		
		if(dbUser.isPresent() && encoder.matches(user.getPassword(), dbUser.get().getPassword())) {
			return true;
		}
		
		return false;
	}

	
	
}
