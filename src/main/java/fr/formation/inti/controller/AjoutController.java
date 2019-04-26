package fr.formation.inti.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.Entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IMessagesService;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Controller
public class AjoutController {

	@Autowired
	@Qualifier("utilisateurValidator")
	private Validator validator;

	@Autowired
	IUtilisateursService serviUtili;

	@Autowired
	IMessagesService serviMess;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	// Regroupe les différentes méthodes pour Ajouter les trucs dans la base de
	// donnée

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/forminscrip", method = RequestMethod.GET)
	// l'ajout
	public String AjouterUtilisateurGET(Model model) throws Exception {

		model.addAttribute("utilisateur", new Utilisateurs());
		return ("Inscription");
	}

	@RequestMapping(value = "/forminscrip", method = RequestMethod.POST)
	public ModelAndView AjouterUtilisateur(@ModelAttribute("utilisateur") Utilisateurs utilisateur,
			BindingResult bindingResult) throws Exception {

		validator.validate(utilisateur, bindingResult);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("Inscription", "utilisateur", utilisateur);
		}

		Utilisateurs user = serviUtili.createUtilisateurs(utilisateur);
//		Messageries messageries = new Messageries(user);
//		serviMess.createMessageries(messageries);

		ModelAndView mav = new ModelAndView("ValidationInscription");
		return mav;
	}
	
//	@RequestMapping(value = "/formMessagerie")
//	@Transactional
//	public ModelAndView AjouterMessagerie(@ModelAttribute("utilisateur") Utilisateurs utilisateur) {
//
//		Messageries messageries = new Messageries(utilisateur);
//		serviMess.createMessageries(messageries);
//		ModelAndView mav = new ModelAndView("ValidationInscription");
//		return mav;
//	}

}
