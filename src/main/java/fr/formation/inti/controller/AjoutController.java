package fr.formation.inti.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import fr.formation.inti.entities.Login;
import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.Utilisateurs;
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

	//initialisation du validateur
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	// Regroupe les diff�rentes m�thodes pour Ajouter les trucs dans la base de
	// donn�e

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/forminscrip", method = RequestMethod.GET)
	// l'ajout
	public String AjouterUtilisateurGET(Model model) throws Exception {

		model.addAttribute("utilisateur", new Utilisateurs());
		return ("Inscription");
	}

	@RequestMapping(value = "/forminscrip", method = RequestMethod.POST)
	public ModelAndView AjouterUtilisateur(@ModelAttribute("utilisateur") Utilisateurs utilisateur,
			BindingResult bindingResult, HttpSession session) throws Exception {

		validator.validate(utilisateur, bindingResult);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("Inscription", "utilisateur", utilisateur);
		}

		serviUtili.createUtilisateurs(utilisateur);
		List<Messages> list = serviMess.getMessagesByUtilisateur(utilisateur);

		Login login = new Login(utilisateur.getIdUtilisateurs(), utilisateur.getLogin(), list.size());
		session.setAttribute("login", login);

		ModelAndView mav = new ModelAndView("ValidationInscription");
		return mav;
	}
	



}
