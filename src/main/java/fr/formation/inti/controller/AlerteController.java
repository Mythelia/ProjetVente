package fr.formation.inti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.Service.SpellCheck;
import fr.formation.inti.entities.Alerte;
import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Login;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IAlertesService;
import fr.formation.inti.interfaces.services.IMotsClefsService;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Controller
public class AlerteController {

	@Autowired
	@Qualifier("alerteValidator")
	private Validator validator;

	@Autowired
	IAlertesService serviAlerte;

	@Autowired
	IUtilisateursService serviUtili;

	@Autowired
	IMotsClefsService mcService;

	@Autowired
	SpellCheck spellCheck;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/formAlerte", method = RequestMethod.GET)
	// l'ajout
	public String AjouterAlerteGet(Model model) throws Exception {

		model.addAttribute("alerte", new Alerte());
		return ("AlerteForm");
	}

	@Transactional
	@RequestMapping(value = "/formAlerte", method = RequestMethod.POST)
	public ModelAndView AjouterAlertePost(@ModelAttribute("alerte") Alerte alerte, BindingResult bindingResult,
			HttpSession session) throws Exception {

		validator.validate(alerte, bindingResult);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("AlerteForm", "alerte", alerte);
		}
		Login login = (Login) session.getAttribute("login");
		int id = login.getIdUtilisateurs();

		Utilisateurs utilisateur = serviUtili.findByIdUtilisateurs(id);
		System.out.println(utilisateur.getIdUtilisateurs());
		alerte.setUtilisateurs(utilisateur);

		String[] motsClefs = alerte.getMotClefs().split(" ");
		for (String motClef : motsClefs) {
			MotsClefs mc = mcService.findByMotclef(motClef);
			if (mc == null) {
				mc = new MotsClefs(motClef);
				mcService.createMotsclefs(mc);
				spellCheck.addMot(motClef);
			}
			alerte.getMotsclefses().add(mc);
		}
		serviAlerte.createAlerte(alerte);

		ModelAndView mav = new ModelAndView("ValidationInscription");
		return mav;
	}

	@RequestMapping(value = "/UpdateAl")

	public ModelAndView UpdateAl(@RequestParam("idAl") int id) throws Exception {

		Alerte alerte = serviAlerte.findByIdAlerte(id);

		return new ModelAndView("ModifAlerte", "alerte", alerte);
	}

	@RequestMapping(value = "/AlerteUpdate")

	public ModelAndView UpdateAlPost(@ModelAttribute("alerte") Alerte alerte, BindingResult bindingResult,
			HttpSession session, @RequestParam("idAlerte") int id) throws Exception {

		validator.validate(alerte, bindingResult);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("AlerteForm", "alerte", alerte);
		}
		alerte.setIdAlerte(id);
		Login login = (Login) session.getAttribute("login");
		alerte.setUtilisateurs(serviUtili.findByIdUtilisateurs(login.getIdUtilisateurs()));
		String[] motsClefs = alerte.getMotClefs().split(" ");
		for (String motClef : motsClefs) {
			MotsClefs mc = mcService.findByMotclef(motClef);
			if (mc == null) {
				mc = new MotsClefs(motClef);
				mcService.createMotsclefs(mc);
				spellCheck.addMot(motClef);
			}
			alerte.getMotsclefses().add(mc);
		}
		
		serviAlerte.updateAlerte(alerte);

		return new ModelAndView("ValidationAlerte");
	}

	@RequestMapping(value = "DeleteAl")
	@Transactional
	public ModelAndView deleteAlerte(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("idAl") Integer idAl) {

		Alerte alerte = serviAlerte.findByIdAlerte(idAl);
		serviAlerte.deleteAlerte(alerte);

		return new ModelAndView("Compte");

	}
}
