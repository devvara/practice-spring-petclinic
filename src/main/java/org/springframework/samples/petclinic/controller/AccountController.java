package org.springframework.samples.petclinic.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.dto.UserDto;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private UserService userService;

	/**
	 * Handles GET request for '/account/login' to display login page.
	 * @return The view template for the login page.
	 */
	@GetMapping("/login")
	public String login() {
		return "account/login";
	}

	/**
	 * Handles GET request for '/account/register' to display register page.
	 * @return The view template for the register page.
	 */
	@GetMapping("/register")
	public String register(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "account/register";
	}

	/**
	 * Handles POST request for '/account/register' to process user registeration.
	 * @param user The user object containing the registration information.
	 * @return A redirection to the home page after successful registration.
	 */
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
		User existingUser = userService.findUserByUsername(userDto.getUsername());

		if (existingUser != null)
			result.rejectValue("username", null, "User already registered !!!");

		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "account/register";
		}

		userService.saveUser(userDto);
		return "redirect:/";
	}
}
