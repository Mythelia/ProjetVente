package fr.formation.inti.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Controller
public class AjoutController {

	@Autowired
	@Qualifier("utilisateurValidator")
	private Validator validator;

	@Autowired
	IUtilisateursService serviUtili;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.setValidator(validator);
	}

	// Regroupe les différentes méthodes pour Ajouter les trucs dans la base de
	// donnée

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/formannonce") // faire la validation + une jsp qui valide l'ajout
	public ModelAndView AjouterAnnonce(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/forminscrip", method = RequestMethod.GET) // faire la validation + une jsp qui valide
	// l'ajout
	public String AjouterUtilisateurGET(Model model) throws Exception {

		model.addAttribute("utilisateur", new Utilisateurs());
		return ("Inscription");
	}

	@RequestMapping(value = "/forminscrip", method = RequestMethod.POST) // faire la validation + une jsp qui valide
																			// l'ajout
	public ModelAndView AjouterUtilisateur(@ModelAttribute("utilisateur") @Validated Utilisateurs utilisateur,
			BindingResult bindingResult) throws Exception {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("Inscription", "utilisateur", utilisateur);
		}


		System.out.println(utilisateur);

		serviUtili.createUtilisateurs(utilisateur);

		ModelAndView mav = new ModelAndView("ValidationInscription");
		return mav;
	}

}
