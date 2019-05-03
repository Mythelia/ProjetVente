package fr.formation.inti.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.Service.SpellCheck;
import fr.formation.inti.entities.Alerte;
import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Login;
import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IAlertesService;
import fr.formation.inti.interfaces.services.IAnnoncesService;
import fr.formation.inti.interfaces.services.IMessagesService;
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

	@Autowired
	IAlertesService serviAlerte;

	@Autowired
	IMessagesService serviMess;

	// initialisation du validateur
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/formannonce", method = RequestMethod.GET)
	public String AjouterAnnonceGET(Model model, HttpSession session) throws Exception {

		model.addAttribute("annonce", new Annonces());
		return ("AjouterAnnonce");
	}

	@RequestMapping(value = "/UpdateAnnonce", method = RequestMethod.POST)
	@Transactional
	public ModelAndView UpdateAnnoncePOST(@ModelAttribute("annonce") @Validated Annonces annonce,
			BindingResult bindingResult, HttpSession session, @RequestParam("idAnn") Integer idAnn) throws Exception {
		System.out.println(annonce.getTitre());
		System.out.println(idAnn);
		if (session.getAttribute("login") == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}
		Login login = (Login) session.getAttribute("login");
		int id = login.getIdUtilisateurs();
		Utilisateurs utilisateurs = serviUtili.findByIdUtilisateurs(id);

		Annonces newAnnonce = serviAnn.findByIdAnnonces(idAnn);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String dateS = dateFormat.format(date);
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateS);

		newAnnonce.setDate(date1);
		newAnnonce.setTitre(annonce.getTitre());
		newAnnonce.setPrix(annonce.getPrix());
		newAnnonce.setDescription(annonce.getDescription());
		newAnnonce.setAdresse(annonce.getAdresse());

		serviAnn.updateAnnonces(newAnnonce);

		List<Annonces> list = serviAnn.getAnnoncesByUtilisateur(utilisateurs);

		return new ModelAndView("VosAnnonces", "annonce", list);

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

		Utilisateurs utilisateurs = serviUtili.findByIdUtilisateurs(id);
		annonce.setUtilisateurs(utilisateurs);

		// Permet d'ajouter les mots clefs dans la base de données si non existant
		String[] motsClefs = annonce.getMotClefs().split(" ");
		for (String motClef : motsClefs) {
			MotsClefs mc = mcService.findByMotclef(motClef);
			if (mc == null) {
				mc = new MotsClefs(motClef);
				mcService.createMotsclefs(mc);
				spellCheck.addMot(motClef);
			}
			mc.getAnnonceses().add(annonce);
		}

		// création de l'annonce
		serviAnn.createAnnonces(annonce);

		// Cette partie permet de vérifier si des alertes ont les mots clefs présents
		// dans l'annonce puis envoie un message si c'est le càs

		// Récupération de "l'utilisateur" qui va envoyer le message
		Utilisateurs utilisateur = serviUtili.findByLoginUtilisateurs("alerte");

		// Récupération de la liste de toutes les alertes
		List<Alerte> list = serviAlerte.getAllAlerte();

		// Ici on sor la liste des mots clefs des alertes
		for (Alerte alerte : list) {
			Set<MotsClefs> set = alerte.getMotsclefses();

			List<MotsClefs> listMc = new ArrayList<MotsClefs>(set);

			// pour chaque mot clef de la liste des alertes
			for (MotsClefs motClefs : listMc) {

				// on compare à la liste des mots clefs présent dans l'annonce nouvellement crée
				for (String motClef : motsClefs) {

					// et si il a des mots clefs en communs, envoie un message
					if (motClef.equals(motClefs.getMotClef())) {
						Messages message = new Messages(utilisateurs, utilisateur, "noreply: Alerte : " + motClef,
								date1,
								"Une nouvelle annonce correspondant à votre alerte est vient d'être mise en ligne ! <form method=\"POST\" action=\"Annonce\"> <button name=\"show\" type=\"submit\" class=\"btn btn-link\"\r\n"
										+ "	value=" + annonce.getIdAnnonces() + ">cliquer ici pour voir l'annonce </button> </form> ");
						serviMess.createMessages(message);
					}
				}
			}
		}

		ModelAndView mav = new ModelAndView("SuccèsAnnonce");
		return mav;

	}

}
