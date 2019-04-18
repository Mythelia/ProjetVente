package fr.formation.inti.validator;

import org.apache.commons.validator.routines.EmailValidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.entities.Utilisateurs;

@Component
public class UtilisateurValidator implements Validator {

	// common-validator library.
	private EmailValidator emailValidator = EmailValidator.getInstance();

	// The classes is supported to Validate
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == UtilisateurValidator.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Utilisateurs utilisateur = (Utilisateurs) target;

		// Check the fields of ApplicantInfo.
		// (See more in property file: messages/validator.property)
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty.applicantForm.nom");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty.applicantForm.mail");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty.applicantForm.mail");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty.applicantForm.mail");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty.applicantForm.mail");
		

		if (!emailValidator.isValid(utilisateur.getMail())) {
			// Error in email field.
			errors.rejectValue("email", "Pattern.applicantForm.email");
		}

	}

}