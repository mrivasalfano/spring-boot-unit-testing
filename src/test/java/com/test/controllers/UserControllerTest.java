package com.test.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.test.dto.UserDTO;
import com.test.services.UserService;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserService userService;
	
	@Test
	public void createUserTest() throws Exception {
		UserDTO user = new UserDTO();
		user.setName("Test");
		user.setEmail("test@test.com");
		
		when(this.userService.createUser(any(UserDTO.class))).thenReturn(user);
		
		this.mockMvc
			.perform(
				MockMvcRequestBuilders.post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"Test\", \"email\": \"test@test.com\"}")
			)
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));		
	}
	
}