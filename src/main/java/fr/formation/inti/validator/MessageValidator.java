package fr.formation.inti.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Component("MessageValidator")
public class MessageValidator implements Validator {

	@Autowired
	IUtilisateursService serviUtili;

	@Override
	public boolean supports(Class<?> clazz) {
		return Messages.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titre", "titre.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "texte", "texte.required");

	}

}
