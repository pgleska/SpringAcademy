package net.put.SpringAcademy.dtos;

import javax.validation.constraints.NotBlank;

import net.put.SpringAcademy.validation.ValidEmail;

public class UserDTO {

	@ValidEmail
	private String email;
	
	@NotBlank(message = "First name must not be blank")
	private String firstName;
	
	public String getEmail() {
		return email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return "User " + firstName + " with email address: " + email;
	}
}
