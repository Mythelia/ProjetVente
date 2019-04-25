package fr.formation.inti.controller;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.Service.SpellCheck;
import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IAnnoncesService;
import fr.formation.inti.interfaces.services.IMessagesService;

@Controller
public class IndexController {
	@Autowired
	IMessagesService serviMess;

	@Autowired
	IAnnoncesService annoMess;
	
	@Autowired
	SpellCheck spellCheck;

	// Possède aussi les controller du Header

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping({ "/", "/index" })
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.info("Returning index view");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/AjouterAnnonce")
	public ModelAndView AjouterAnnonce(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("AjouterAnnonce");
	}

	@RequestMapping(value = "/Connection")
	public ModelAndView Connection(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		return mav;
	}

	@RequestMapping(value = "/Messagerie")
	public ModelAndView Messagerie(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Messages> list = serviMess.getAllMessages();
		logger.info("Returning AjouterAnnonce view");
		ModelAndView modelAndView = new ModelAndView("Messagerie", "list", list);
		return modelAndView;
	}
	
//	@RequestMapping(value="/Search")
//	public ModelAndView Recherche(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		String mDemande = (String) request.getAttribute("searchC");
//		System.out.println(mDemande);
//		System.out.println(spellCheck.search(mDemande));
//		ModelAndView modelAndView = new ModelAndView("index");
//		return modelAndView;
//		
//		
//	}

	
}
