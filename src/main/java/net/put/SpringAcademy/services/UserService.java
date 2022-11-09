package net.put.SpringAcademy.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.put.SpringAcademy.dtos.UserDTO;

@Service
public class UserService {

	public Map<String, String> createUser(UserDTO user, BindingResult bindingResult) {
		Map<String, String> result = new HashMap<>();
		
		if(bindingResult.hasErrors()) {
			result.put("message", "something went wrong");
			result.put("errors", bindingResult.getAllErrors()
					.stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList())
					.toString());
		} else {
			result.put("email", user.getEmail());
			result.put("firstName", user.getFirstName());
			result.put("message", "created");
		}				
		
		return result;
	}
	
	public Map<String, String> showFunctionWhichThrowsException() throws Exception {
		saveToDB();
		return Collections.emptyMap();
	}
	
	private void saveToDB() throws Exception {
		throw new Exception("Cannot connect to db");
	}		
}
