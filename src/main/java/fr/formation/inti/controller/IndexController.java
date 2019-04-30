package fr.formation.inti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.Service.SpellCheck;
import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Login;
import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IAnnoncesService;
import fr.formation.inti.interfaces.services.IMessagesService;
import fr.formation.inti.interfaces.services.IMotsClefsService;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Controller
public class IndexController {
	@Autowired
	IMessagesService serviMess;

	@Autowired
	IAnnoncesService serviAnno;

	@Autowired
	IUtilisateursService serviUtili;

	@Autowired
	SpellCheck spellCheck;

	@Autowired
	IMotsClefsService serviMots;

	// Possède aussi les controller du Header

	protected final Log logger = LogFactory.getLog(getClass());

	
	
	@RequestMapping({ "/", "/index" })
	@Transactional
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
		List<Annonces> lastAnnonces = serviAnno.getLastAnnonces();
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("lastAnnonces", lastAnnonces);
		
		
		return modelAndView;
	}

	@RequestMapping(value = "/AjouterAnnonce")
	public ModelAndView AjouterAnnonce(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		if (session.getAttribute("login") == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}
		ModelAndView mav = new ModelAndView("AjouterAnnonce", "annonce", new Annonces());

		return mav;
	}

	@RequestMapping(value = "/Connection")
	public ModelAndView Connection(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		Login login = (Login) session.getAttribute("login");
		if (login != null) {

			return new ModelAndView("Compte");
		}

		ModelAndView mav = new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		return mav;
	}

	@RequestMapping(value = "/Messagerie")
	public ModelAndView Messagerie(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		Login login = (Login) session.getAttribute("login");
		if (session.getAttribute("login") == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}
		int idUtilisateur = login.getIdUtilisateurs();
		String loginUtili = login.getLogin();

		Utilisateurs utilisateur = serviUtili.findByLoginUtilisateurs(loginUtili);

		List<Messages> list = serviMess.getMessagesByUtilisateur(utilisateur);

		ModelAndView modelAndView = new ModelAndView("Messagerie", "list", list);
		return modelAndView;
	}

}
