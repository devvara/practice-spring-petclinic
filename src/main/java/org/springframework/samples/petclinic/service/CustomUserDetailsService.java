package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(usernameOrEmail);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(),
				user.getRoles().stream()
					.map((role) -> new SimpleGrantedAuthority(role.getName()))
					.collect(Collectors.toList()));
		} else {
			throw new UsernameNotFoundException("Invalid email or password");
		}
	}
}
