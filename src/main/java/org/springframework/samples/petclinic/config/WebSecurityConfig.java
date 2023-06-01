package org.springframework.samples.petclinic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/").permitAll()
				.requestMatchers("/account/**").permitAll()
				.requestMatchers("/resources/**").permitAll()
				.requestMatchers("/user/**").hasAnyRole("USER")
				.requestMatchers("/admin/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/account/login")
				.loginProcessingUrl("/account/login")
				.defaultSuccessUrl("/")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
			.exceptionHandling().accessDeniedPage("/access-denied");
		return http.build();
	}
}
