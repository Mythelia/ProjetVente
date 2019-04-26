package fr.formation.inti.controller;

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

import fr.formation.inti.Entities.Annonces;
import fr.formation.inti.Entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IAnnoncesService;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Controller
public class AjouterAnnonceControler {

	@Autowired
	@Qualifier("annonceValidator")
	private Validator validator;

	@Autowired
	IAnnoncesService serviAnn;

	@Autowired
	IUtilisateursService serviUtili;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
//		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.setValidator(validator);
	}

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/formannonce", method = RequestMethod.GET)
	public String AjouterAnnonceGET(Model model) throws Exception {

		model.addAttribute("annonce", new Annonces());
		return ("AjouterAnnonce");
	}

	@RequestMapping(value = "/formannonce", method = RequestMethod.POST)
	@Transactional
	public ModelAndView AjouterAnnoncePOST(@ModelAttribute("annonce") @Validated Annonces annonce,
			BindingResult bindingResult) throws Exception {

		validator.validate(annonce, bindingResult);

		if (bindingResult.hasErrors()) {
			return new ModelAndView("AjouterAnnonce", "annonce", annonce);
		}
		Utilisateurs utilisateurs = serviUtili.findByIdUtilisateurs(0);
		annonce.setUtilisateurs(utilisateurs);
//		Transactions trans = new Transactions(0, utilisateurs);
//		annonce.setTransactions(trans);
		// !!!! Ajouter la session et voir pour récup l'id de l'utilisateur

		serviAnn.createAnnonces(annonce);
		ModelAndView mav = new ModelAndView("ValidationInscription");
		return mav;
	}

}
