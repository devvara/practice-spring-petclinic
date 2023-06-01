package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.dto.UserDto;
import org.springframework.samples.petclinic.model.User;

public interface UserService {
	void saveUser(UserDto userDto);

	User findUserByUsername(String username);
}
