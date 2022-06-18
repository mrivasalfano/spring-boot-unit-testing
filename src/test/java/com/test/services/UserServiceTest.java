package com.test.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.dto.UserDTO;
import com.test.entities.User;
import com.test.repositories.IUserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private IUserRepository userRepository;
	
	@InjectMocks
	UserService userService;
	
	@Test
	public void createUserTest() {
		User user = new User();
		user.setName("Test");
		user.setEmail("test@test.com");
		
		when(userRepository.save(any(User.class))).thenReturn(user);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		
		UserDTO savedUserDTO = this.userService.createUser(userDTO);
		
		assertThat(savedUserDTO).isNotNull();
	}
	
}