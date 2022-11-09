package net.put.SpringAcademy.controllers;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> helloWorld() {
		return Map.of("Hello", "World");
	}
	
}
