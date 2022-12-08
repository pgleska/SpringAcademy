package net.put.SpringAcademy.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.put.SpringAcademy.dtos.UserDTO;
import net.put.SpringAcademy.services.UserService;

@RestController
@RequestMapping("/user")
public class UserContoller {

	private static final Logger logger = LoggerFactory.getLogger(UserContoller.class);
	
	private UserService userService;
	
	public UserContoller(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO getUser() {
		UserDTO user = new UserDTO();
		
		user.setFirstName("John");
		user.setEmail("johndoe@gmail.com");
		
		return user;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> createUser(@Valid @RequestBody UserDTO user, BindingResult bindingResult) {
		return userService.createUser(user, bindingResult);
	}
	
	@GetMapping(value = "/logger", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> showLoggerUsage() {
		
		logger.info("This message is always displayed");
		logger.debug("Logging level in application.properties must be set to DEBUG");
		
		try {
			userService.showFunctionWhichThrowsException();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return Map.of("show", "logger");
	}
}
