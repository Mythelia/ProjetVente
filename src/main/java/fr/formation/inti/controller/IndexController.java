package fr.formation.inti.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/index.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning index view");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/AjouterAnnonce.htm")
	public ModelAndView AjouterAnnonce(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("AjouterAnnonce");
	}

	@RequestMapping(value = "/Connection.htm")
	public ModelAndView Connection(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("Connection");
	}
	
	@RequestMapping(value = "/Messagerie.htm")
	public ModelAndView Messagerie(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("Messagerie");
	}


}
