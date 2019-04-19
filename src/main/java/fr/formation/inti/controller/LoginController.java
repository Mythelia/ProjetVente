package fr.formation.inti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/Login") // Rajouter le systeme de session
	public ModelAndView Login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("Compte");
	}

	@RequestMapping(value = "/MDPOubli")
	public ModelAndView MDPOubli(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("MdpOubli");
	}
	
	@RequestMapping(value = "/Inscription")
	public ModelAndView Inscription(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("Inscription");
	}

}
