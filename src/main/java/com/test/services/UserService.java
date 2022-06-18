package com.test.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.UserDTO;
import com.test.entities.User;
import com.test.repositories.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository userRepository;
	
	public UserDTO getUserById(Long id) {
		Optional<User> user = this.userRepository.findById(id);
		
		if (user.isEmpty())
			return null;
		
		return this.mapUserToUserDTO(user.get());
	}
	
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.mapUserDTOToUser(userDTO);
		User savedUser = this.userRepository.save(user);
		return this.mapUserToUserDTO(savedUser);
	}

	private User mapUserDTOToUser(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

	private UserDTO mapUserToUserDTO(User user) {
		return new UserDTO(user.getId(), user.getName(), user.getEmail());
	}
	
}