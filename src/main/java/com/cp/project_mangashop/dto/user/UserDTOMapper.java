package com.cp.project_mangashop.dto.user;

import com.cp.project_mangashop.entity.User;

public class UserDTOMapper {

	public static User DTOToUser(UserDTO userDTO) {
		User user = new User();
		
		user.setUserId(userDTO.getUserId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setRole(userDTO.getRole());
		
		return user;
		
	}
	
	public static UserDTO UserToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(user.getUserId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		userDTO.setRole(user.getRole());
		
		return userDTO;
		
	}
	
}
