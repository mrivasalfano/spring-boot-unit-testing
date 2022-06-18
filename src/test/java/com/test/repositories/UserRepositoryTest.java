package com.test.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.test.entities.User;

import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private IUserRepository userRepository;
	
	@Test
	public void saveUserTest() {
		User user = new User();
		user.setName("test");
		user.setEmail("test@test.com");
		
		User savedUser = this.userRepository.save(user);
		
		assertThat(savedUser).isNotNull();
	}
	
}