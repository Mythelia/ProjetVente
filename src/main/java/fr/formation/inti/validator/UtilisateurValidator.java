package fr.formation.inti.validator;

import org.apache.commons.validator.routines.EmailValidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.entities.Utilisateurs;

@Component("utilisateurValidator")
public class UtilisateurValidator implements Validator {
	// common-validator library.
	private EmailValidator emailValidator = EmailValidator.getInstance();

	// The classes is supported to Validate
	@Override
	public boolean supports(Class<?> clazz) {

		return Utilisateurs.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Utilisateurs utilisateur = (Utilisateurs) target;

		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty.applicantForm.nom");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prénom", "NotEmpty.applicantForm.prénom");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty.applicantForm.mail");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codePostal", "NotEmpty.applicantForm.codePostal");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty.applicantForm.login");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.applicantForm.password");

		if (!emailValidator.isValid(utilisateur.getMail())) {
			
			errors.rejectValue("mail", "Pattern.applicantForm.email");
		}

	}

}