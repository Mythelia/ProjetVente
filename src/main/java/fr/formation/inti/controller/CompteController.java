package fr.formation.inti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompteController {
	
	protected final Log logger = LogFactory.getLog(getClass());

	//voir messagerie et publier annonce déjà dans index controller
	
	@RequestMapping(value = "/ModifProfil")
	public ModelAndView ModifProfil(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("ModifProfil");
	}
	@RequestMapping(value = "/VosAnn") 
	public ModelAndView VosAnnonnces(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("VosAnnonces");
	}
	@RequestMapping(value = "/Logout") // faire ma méthode
	public ModelAndView SeDeconnecter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("Compte");
	}
	@RequestMapping(value = "/Desinscrip") // jsp à faire
	public ModelAndView Desinscription(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("Compte");
	}
}
