package fr.formation.inti.validator;

import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Component("utilisateurValidator")
public class UtilisateurValidator implements Validator {

	@Autowired
	IUtilisateursService utiliserv;

	// common-validator library.
	private EmailValidator emailValidator = EmailValidator.getInstance();

	// The classes is supported to Validate
	@Override
	public boolean supports(Class<?> clazz) {

		return Utilisateurs.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Utilisateurs utilisateur = (Utilisateurs) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty.applicantForm.nom");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty.applicantForm.prenom");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty.applicantForm.mail");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codePostal", "NotEmpty.applicantForm.codePostal");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty.applicantForm.login");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.applicantForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateNaissance", "NotEmpty.applicantForm.date");

		if (!emailValidator.isValid(utilisateur.getMail())) {

			errors.rejectValue("mail", "Pattern.applicantForm.email");
		}

		List<Utilisateurs> list = utiliserv.getAllUtilisateurs();
		for (Utilisateurs utilisateurs : list) {
			if (utilisateurs.getLogin().equals(utilisateur.getLogin())) {
				errors.rejectValue("login", "NotUnique.Login");

			}
		}

	}

}