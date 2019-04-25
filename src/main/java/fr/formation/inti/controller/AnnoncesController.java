package fr.formation.inti.controller;

import java.util.List;
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
import fr.formation.inti.entities.Messages;

@Controller
public class AnnoncesController {
	
	@Autowired
	SpellCheck spellCheck;

	protected final Log logger = LogFactory.getLog(getClass());
	
	public Set<Annonces> SortAnnonces(String mDemande) {
		TreeMap<Integer, String> results = spellCheck.search(mDemande);
		Set<Annonces> annonces;
		String motClefPlusAbondant = results.lastEntry().getValue();
		// Si le mot demandé est celui correspondant au plus grand nombre d'entrées dans la base
		if (motClefPlusAbondant.equals(mDemande)) {
			annonces = spellCheck.getAnnonces(mDemande);
		}
		else {
			annonces = spellCheck.getAnnonces(motClefPlusAbondant);
			// TODO : gérer la logique
		}
		return annonces;
		}
	
	@RequestMapping(value = "/Search")
	public ModelAndView Search(HttpServletRequest request, HttpServletResponse response, @RequestParam("searchC") String mDemande) throws Exception {

		Set<Annonces> annonces = this.SortAnnonces(mDemande);
		logger.info("Returning AjouterAnnonce view");
		ModelAndView modelAndView = new ModelAndView("showAnnonces", "annonces", annonces);
		return modelAndView;
	}

}
