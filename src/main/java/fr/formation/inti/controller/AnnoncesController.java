package fr.formation.inti.controller;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.Service.SpellCheck;
import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.Login;
import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IAnnoncesService;
import fr.formation.inti.interfaces.services.IMotsClefsService;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Controller
public class AnnoncesController {

	@Autowired
	IUtilisateursService utilisateursService;

	@Autowired
	SpellCheck spellCheck;

	@Autowired
	IAnnoncesService annonceService;

	@Autowired
	IMotsClefsService mcService;

	@Autowired
	IUtilisateursService serviUtili;

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "UpdateAnn")
	@Transactional
	public ModelAndView updateAnnonce(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("idAnn") int idAnn) {

		System.out.println(idAnn);
		Annonces annonce = annonceService.findByIdAnnonces(idAnn);
		String motClefs = "";
		for (MotsClefs mc : annonce.getMotsclefses()) {
			motClefs += mc.getMotClef() + " ";
		}
		annonce.setMotClefs(motClefs);

		ModelAndView modelAndView = new ModelAndView("UpdateAnnonces", "annonce", annonce);
		return modelAndView;

	}

	@RequestMapping(value = "DeleteAn")
	@Transactional
	public ModelAndView deleteAnnonce(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("id") Integer idAnn) {

		Annonces annonce = annonceService.findByIdAnnonces(idAnn);

		Set<MotsClefs> mcAnnonce = annonce.getMotsclefses();

		for (MotsClefs mc : mcAnnonce) {
			mc.getAnnonceses().remove(annonce);
			for (Annonces an : mc.getAnnonceses()) {
				System.out.println(an.getTitre());
			}
			if (!mc.getAnnonceses().isEmpty()) {
				mcService.updateMotsclefs(mc);
			} else {
				mcService.deleteMotsclefs(mc);
				// TODO : mettre à jour spellcheck
			}
		}

		annonceService.deleteAnnonces(annonce);

		if (session.getAttribute("login") == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}
		Login login = (Login) session.getAttribute("login");
		int idUtil = login.getIdUtilisateurs();
		ModelAndView mv = new ModelAndView("Compte");
		return mv;

	}

	@RequestMapping(value = "/Search")
	public ModelAndView Search(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("searchC") String mDemande) throws Exception {

		String otherWord;
		mDemande = SpellCheck.removeAccents(mDemande);
		String message = "Voici les résultats pour " + mDemande + " :";
		TreeMap<Integer, String> results = spellCheck.search(mDemande);
		Set<Annonces> annonces;
		if (results.isEmpty()) {
			message = "Aucun résultat pour " + mDemande + " =( !";
			ModelAndView modelAndView = new ModelAndView("showAnnonces", "annonces", null);
			modelAndView.addObject("message", message);
			return modelAndView;
		}
		String motClefPlusAbondant = results.lastEntry().getValue();
		String autreRecherche = null;
		// Si le mot demandé est celui correspondant au plus grand nombre d'entrées dans
		// la base
		if (motClefPlusAbondant.equals(mDemande)) {
			annonces = spellCheck.getAnnonces(mDemande);
			otherWord = null;
		} else {
			annonces = spellCheck.getAnnonces(motClefPlusAbondant);
			annonces.addAll(spellCheck.getAnnonces(mDemande));
			otherWord = motClefPlusAbondant;
		}
		if (mDemande.equals(otherWord)) {
			message = "Voici les résultats pour " + mDemande + " :";
		} else if (otherWord != null) {
			message = "Vous aviez recherché " + mDemande + " mais peut-être vouliez vous dire " + otherWord + " ?\n"
					+ "Voici les résultats pour " + otherWord + " et " + mDemande + " :\n"
					+ "Rechercher uniquement pour " + mDemande;
			autreRecherche = mDemande;
		}

		logger.info("Returning AjouterAnnonce view");
		ModelAndView modelAndView = new ModelAndView("showAnnonces", "annonces", annonces);
		modelAndView.addObject("message", message);
		modelAndView.addObject("autreRecherche", autreRecherche);
		return modelAndView;
	}

	@RequestMapping(value = "Annonce")
	public ModelAndView showAnnonce(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("show") int idAnnonce) {
		Annonces annonce = annonceService.findByIdAnnonces(idAnnonce);
		System.out.println(annonce.getDescription());
		return new ModelAndView("showAnnonce", "annonce", annonce);
	}

	@RequestMapping(value = "searchAgain")
	public ModelAndView showAnnonce(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("annonceAgain") String mot) {
		Set<Annonces> annonces = spellCheck.getAnnonces(mot);
		String message = "Voici les résultats pour " + mot + " :";
		ModelAndView modelAndView = new ModelAndView("showAnnonces", "annonces", annonces);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@Transactional
	@RequestMapping(value = "AcheterAnn")
	public ModelAndView AcheterAnnonce(HttpSession session, @RequestParam("idAnnonce") int id) {

		Login login = (Login) session.getAttribute("login");
		if (login == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}

		Annonces annonce = annonceService.findByIdAnnonces(id);
		System.out.println(annonce.getTitre());

		return new ModelAndView("AccepterAnnonce", "annonce", annonce);

	}

	@Transactional
	@RequestMapping(value = "AnnonceAchete")
	public ModelAndView AnnonceAchete(HttpSession session, @RequestParam("idAnnonce") int id) {

		Login login = (Login) session.getAttribute("login");
		if (login == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}

		Annonces annonce = annonceService.findByIdAnnonces(id);
		System.out.println(annonce.getTitre());
		annonceService.deleteAnnonces(annonce);

		return new ModelAndView("ValidationAchat");

	}

}
