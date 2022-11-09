package net.put.SpringAcademy.validation;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

	private Matcher matcher;
	private String emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	private Pattern pattern = Pattern.compile(emailPattern);
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(Objects.isNull(email)) return false;
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
