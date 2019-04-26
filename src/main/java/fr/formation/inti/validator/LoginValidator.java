package fr.formation.inti.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.Entities.Utilisateurs;

@Component("loginValidator")
public class LoginValidator implements Validator {



	@Override
	public boolean supports(Class<?> clazz) {

		return Utilisateurs.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

	

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordString", "passwordString.required");

	

	}

}
