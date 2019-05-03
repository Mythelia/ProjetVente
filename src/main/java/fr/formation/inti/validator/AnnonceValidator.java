package fr.formation.inti.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.entities.Annonces;

@Component("annonceValidator")
public class AnnonceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Annonces.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titre", "titre.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adresse", "adresse.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prix", "prix.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");

	}

}
