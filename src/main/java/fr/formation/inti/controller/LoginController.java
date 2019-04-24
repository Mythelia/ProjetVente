package fr.formation.inti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entities.Login;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("loginValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	IUtilisateursService utilisateursService;

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String displayLogin(Model model) {
		model.addAttribute("utilisateurs", new Utilisateurs());
		return ("Connection");
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST) // Rajouter le systeme de session
	public ModelAndView Login(@ModelAttribute("utilisateurs") @Validated Utilisateurs utilisateurs,
			BindingResult bindingResult, HttpSession session) throws Exception {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("Connection", "utilisateurs", utilisateurs);
		}
		try {
			System.out.println(0);
//			Utilisateurs registeredUtilisateur = utilisateursService.findByLoginUtilisateurs(utilisateurs.getLogin());
			System.out.println(utilisateurs.getLogin());
			Utilisateurs registeredUtilisateur = utilisateursService.findByIdUtilisateurs(1);
			System.out.println(registeredUtilisateur);
			if (registeredUtilisateur == null) {
				ModelAndView returnPage = new ModelAndView("Connection", "utilisateurs", utilisateurs);
				String msg = "Cet utilisateur n'existe pas !";
				returnPage.addObject("msg",msg );
				return returnPage;
				// Chercher comment ajouter une erreur dans le truc

			} else {
				System.out.println(1);
				if (utilisateurs.getPassword() == registeredUtilisateur.getPassword()) {
					Login login = new Login(utilisateurs.getIdUtilisateurs(), utilisateurs.getLogin());
					session.setAttribute("login", login);
					System.out.println(2);
				} else {
					ModelAndView returnPage = new ModelAndView("Connection", "utilisateurs", utilisateurs);
					String msg = "Mot de passe incorrect !";
					returnPage.addObject("msg",msg );
					System.out.println(3);
					return returnPage;
				}
			}
		}

		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
//		if (utilisateursService.findByLoginUtilisateurs(utilisateurs.getLogin()) == null) {
//			return new ModelAndView("Inscription", "utilisateurs", utilisateurs);
//		}
//		else {
//			
//		}

		ModelAndView mav = new ModelAndView("Compte", "utilisateurs", utilisateurs);
		return mav;
	}

	@RequestMapping(value = "/MDPOubli")
	public ModelAndView MDPOubli(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Returning AjouterAnnonce view");
		return new ModelAndView("MdpOubli");
	}

	@RequestMapping(value = "/Inscription")
	public ModelAndView Inscription() throws Exception {
		ModelAndView mav = new ModelAndView("Inscription", "utilisateur", new Utilisateurs());
		return mav;
	}

}
