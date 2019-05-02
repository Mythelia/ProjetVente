package fr.formation.inti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

@Controller
public class LoginController {

	@Autowired
	@Qualifier("loginValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String displayLogin(Model model) {
		model.addAttribute("utilisateurs", new Utilisateurs());
		return ("Connection");
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST) // Rajouter le systeme de session
	public ModelAndView Login(@ModelAttribute("utilisateurs") @Validated Utilisateurs utilisateurs,
			BindingResult bindingResult) throws Exception {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("Connection", "utilisateurs", utilisateurs);
		}

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
