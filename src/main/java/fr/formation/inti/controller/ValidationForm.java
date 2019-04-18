package fr.formation.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Utilisateurs;

@Controller
public class ValidationForm {

	@RequestMapping(value = "/forminscrip", method = RequestMethod.POST)
	public String saveUtilisateur(@Validated Utilisateurs utili, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "Inscription";
		}
		model.addAttribute("utilisateur", utili);

		return "#";
	}

	@RequestMapping(value = "/formannonce", method = RequestMethod.POST)
	public String saveAnnonce(@Validated Annonces annonce, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "AjouterAnnonce";
		}
		model.addAttribute("annonce", annonce);

		return "#";
	}

}
