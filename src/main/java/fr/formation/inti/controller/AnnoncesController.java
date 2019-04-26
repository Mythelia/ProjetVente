package fr.formation.inti.controller;

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
import fr.formation.inti.interfaces.services.IAnnoncesService;

@Controller
public class AnnoncesController {

	@Autowired
	SpellCheck spellCheck;

	@Autowired
	IAnnoncesService annonceService;

	private static String otherWord;

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/Search")
	public ModelAndView Search(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("searchC") String mDemande) throws Exception {

		// TODO : attention si le mot clef renvoyé n'est pas celui demandé
		String otherWord;
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
		// Si le mot demandé est celui correspondant au plus grand nombre d'entrées dans
		// la base
		if (motClefPlusAbondant.equals(mDemande)) {
			annonces = spellCheck.getAnnonces(mDemande);
			otherWord = null;
		} else {
			annonces = spellCheck.getAnnonces(motClefPlusAbondant);
			otherWord = motClefPlusAbondant;
		}
		if (mDemande.equals(otherWord)) {
			message = "Voici les résultats pour " + mDemande + " :";
		} else if (otherWord != null) {
			message = "Vous aviez recherché " + mDemande + " mais peut-être vouliez vous dire " + otherWord + " ?\n"
					+ "Voici les résultats pour " + otherWord + " :";
		}
//		for (Annonces an : annonces) {
//			System.out.println(an.getDescription()); // TODO a degager
//			System.out.println(an.getPhoto());
//		}
		logger.info("Returning AjouterAnnonce view");
		ModelAndView modelAndView = new ModelAndView("showAnnonces", "annonces", annonces);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "Annonce")
	public ModelAndView showAnnonce(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("show") int idAnnonce) {
		Annonces annonce = annonceService.findByIdAnnonces(idAnnonce);
		System.out.println(annonce.getDescription());
		return null;
	}
}
