package com.cp.project_mangashop.dto.user;

import com.cp.project_mangashop.dto.cart.CartCreateDTO;
import com.cp.project_mangashop.dto.cart.CartDTOMapper;
import com.cp.project_mangashop.entity.Cart;
import com.cp.project_mangashop.entity.User;

public class UserDTOMapper {

	public static User DTOToUser(UserDTO userDTO) {
		User user = new User();
		
		user.setUserId(userDTO.getUserId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setRole(userDTO.getRole());
		user.setCart(CartDTOMapper.DTOToCart(userDTO.getCart()));
		
		return user;
		
	}
	
	public static UserDTO UserToDTOVisual(User user, Cart cart) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(user.getUserId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		userDTO.setRole(user.getRole());
		userDTO.setCart(CartDTOMapper.CartToDTO(cart));
		
		return userDTO;
		
	}
	
	public static UserDTO UserToDTO(User user, Cart cart) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(user.getUserId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		userDTO.setRole(user.getRole());
		userDTO.setCartCreate(CartDTOMapper.CartToDTOCreate(cart));
		
		return userDTO;
		
	}
	
	public static UserDTO UserToDTOUpdateCart(User user, Cart cart) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(user.getUserId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		userDTO.setRole(user.getRole());
		userDTO.setCart((CartDTOMapper.CartToDTO(cart)));
		
		return userDTO;
		
	}
	
	public static UserDTO UserToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(user.getUserId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		userDTO.setRole(user.getRole());
		userDTO.setCart(CartDTOMapper.CartToDTO(user.getCart()));
		
		return userDTO;
		
	}
	
}
