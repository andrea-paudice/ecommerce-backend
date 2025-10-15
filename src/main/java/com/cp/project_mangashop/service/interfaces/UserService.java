package com.cp.project_mangashop.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.cp.project_mangashop.dto.user.UserDTO;
import com.cp.project_mangashop.entity.User;

public interface UserService {

	public User getUser(int id_user);
	public User insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id_user);
	public List<User> getAllUsers();
	public User findByUsername(String username);
	public boolean login(User user);
	
}
