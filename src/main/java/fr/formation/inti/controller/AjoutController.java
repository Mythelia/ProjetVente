package fr.formation.inti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjoutController {
	
	//Regroupe les différentes méthodes pour Ajouter les trucs dans la base de donnée
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/formannonce" ) //faire la validation + une jsp qui valide l'ajout
	public ModelAndView AjouterAnnonce(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/forminscrip") // faire la validation + une jsp qui valide l'ajout
	public ModelAndView AjouterUtilisateur(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("index");
	}

}
