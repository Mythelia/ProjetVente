package fr.formation.inti.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.entities.Alerte;

@Component("alerteValidator")
public class AlerteValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Alerte.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motClefs", "motsclefses.required");

	}

}
