package fr.formation.inti.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

import fr.formation.inti.Service.SpellCheck;
import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Login;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IAnnoncesService;
import fr.formation.inti.interfaces.services.IMotsClefsService;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Controller
public class AjouterAnnonceControler {

	@Autowired
	@Qualifier("annonceValidator")
	private Validator validator;

	@Autowired
	SpellCheck spellCheck;

	@Autowired
	IAnnoncesService serviAnn;

	@Autowired
	IMotsClefsService mcService;

	@Autowired
	IUtilisateursService serviUtili;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
//		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.setValidator(validator);
	}

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/formannonce", method = RequestMethod.GET)
	public String AjouterAnnonceGET(Model model, HttpSession session) throws Exception {
		
		Login login = (Login) session.getAttribute("login");
		
		model.addAttribute("annonce", new Annonces());
		return ("AjouterAnnonce");
	}

	@RequestMapping(value = "/formannonce", method = RequestMethod.POST)
	@Transactional
	public ModelAndView AjouterAnnoncePOST(@ModelAttribute("annonce") @Validated Annonces annonce,
			BindingResult bindingResult, HttpSession session) throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // surement pas optimisé
		Date date = new Date();
		String dateS = dateFormat.format(date);
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateS);
		annonce.setDate(date1);

		validator.validate(annonce, bindingResult);

		if (bindingResult.hasErrors()) {
			return new ModelAndView("AjouterAnnonce", "annonce", annonce);
		}

		Login login = (Login) session.getAttribute("login");
		int id = login.getIdUtilisateurs();

		Utilisateurs utilisateurs = serviUtili.findByIdUtilisateurs(id); // TODO : bug nullpointer si l'utilisateur
																			// n'est pas loggé
		annonce.setUtilisateurs(utilisateurs);

		String[] motsClefs = annonce.getMotClefs().split(" ");
		for (String motClef : motsClefs) {
			MotsClefs mc = mcService.findByMotclef(motClef);
			if (mc == null) {
				mc = new MotsClefs(motClef);
				mcService.createMotsclefs(mc);
				spellCheck.addMot(motClef);
			}
			annonce.getMotsclefses().add(mc);
		}

		serviAnn.createAnnonces(annonce);

//		String[] motsClefs = annonce.getMotsClefs().split(" ");
//
//		for (String motClef : motsClefs) {
//
//			MotsClefs alreadyHere = mcService.findByMotclef(motClef);
//			int mcId;
//			if (null == alreadyHere) {
//				alreadyHere = new MotsClefs(motClef);
//				mcService.createMotsclefs(alreadyHere);
//				alreadyHere = mcService.findByMotclef(motClef);
//			}
//			// TODO : compléter, et gérer le cas dans la table intermédiaire, et gérer la
//			// suppression
//
//		}

		ModelAndView mav = new ModelAndView("ValidationInscription");
		return mav;

	}

}
