package fr.formation.inti.controller;

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

import fr.formation.inti.entities.Login;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Controller
public class CompteController {
	@Autowired
	IUtilisateursService utilisateursService;

	protected final Log logger = LogFactory.getLog(getClass());

	// voir messagerie et publier annonce déjà dans index controller
	@Transactional
	@RequestMapping(value = "/ModifProfil")
	public ModelAndView ModifProfil(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		if (session.getAttribute("login") == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}
		Login login = (Login) session.getAttribute("login");
		Utilisateurs utilisateur = utilisateursService.findByIdUtilisateurs(login.getIdUtilisateurs());
		return new ModelAndView("ModifProfil", "utilisateur", utilisateur);
	}

	@RequestMapping(value = "/VosAnn")
	public ModelAndView VosAnnonnces(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		if (session.getAttribute("login") == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}

		return new ModelAndView("VosAnnonces");
	}

	@RequestMapping(value = "/Logout")
	public ModelAndView SeDeconnecter(HttpSession session) throws Exception {
		System.out.println(session.getAttribute("login"));
		if (session.getAttribute("login") == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}

		session.setAttribute("login", null);

		return new ModelAndView("index");
	}

	@RequestMapping(value = "/Desinscrip") // jsp à faire
	public ModelAndView Desinscription(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		if (session.getAttribute("login") == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}

		return new ModelAndView("Compte");
	}
}
