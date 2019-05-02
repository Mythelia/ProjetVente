package fr.formation.inti.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entities.Login;
import fr.formation.inti.entities.Messages;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IMessagesService;
import fr.formation.inti.interfaces.services.IUtilisateursService;

@Controller
public class MessagerieController {

	@Autowired
	@Qualifier("MessageValidator")
	private Validator validator;

	// initialisation du validateur
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	IUtilisateursService serviUtili;

	@Autowired
	IMessagesService serviMess;

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "DeleteMess", method = RequestMethod.GET)
	public ModelAndView DeleteMessGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView("Messagerie");
	}

	@RequestMapping(value = "DeleteMess", method = RequestMethod.POST)
	public ModelAndView DeleteMessPost(@RequestParam("id") int id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Messages mess = serviMess.findByIdMessages(id);
		serviMess.deleteMessages(mess);

		return new ModelAndView("Messagerie");
	}

	@RequestMapping(value = "NouveauMessage")
	public ModelAndView NouveauMessage() {

		return new ModelAndView("MessageForm", "message", new Messages());

	}

	@RequestMapping(value = "formMessage", method = RequestMethod.GET)
	public ModelAndView ValidationMessageGet(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return new ModelAndView("MessageForm", "message", new Messages());

	}

	@Transactional
	@RequestMapping(value = "formMessage", method = RequestMethod.POST)
	public ModelAndView ValidationMessagePost(HttpSession session, @ModelAttribute("message") Messages message,
			BindingResult bindingResult, @RequestParam("utilisateurName") String Pseudo) throws Exception {

		Utilisateurs utilisateurR;

		// Vérifie si le Pseudo existe

		// récupération de l'utilisateur receveur
		utilisateurR = serviUtili.findByLoginUtilisateurs(Pseudo);
		if (utilisateurR == null) {
			ModelAndView mav = new ModelAndView("MessageForm", "message", message);
			String msg = "Le Pseudo n'existe pas !";
			mav.addObject("msgpass", msg);
			return new ModelAndView("MessageForm", "message", message);

		}
		message.setUtilisateursByIdUtilisateurReceveur(utilisateurR);

		validator.validate(message, bindingResult);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("MessageForm", "message", message);
		}

		Login login = (Login) session.getAttribute("login");
		int idUtilisateur = login.getIdUtilisateurs(); // id de l'utilisateur expediteur
		Utilisateurs utilisateurE = serviUtili.findByIdUtilisateurs(idUtilisateur);

		message.setUtilisateursByIdUtilisateurExpediteur(utilisateurE);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // surement pas optimisé
		Date date = new Date();
		String dateS = dateFormat.format(date);
		Date date1 = new SimpleDateFormat("yyy/MM/dd").parse(dateS);

		message.setDate(date1);

		serviMess.createMessages(message);

		return new ModelAndView("ValidationMail");
	}

	@Transactional
	@RequestMapping(value = "LectureMessage")
	public ModelAndView LireMessage(@RequestParam("idMessage") int id) {

		Messages message = serviMess.findByIdMessages(id);
		System.out.println(message.getUtilisateursByIdUtilisateurExpediteur()); // sinon ça crash......

		return new ModelAndView("AfficherMessage", "message", message);

	}

	@Transactional
	@RequestMapping(value = "repMessage")
	public ModelAndView RépondreMessage(HttpSession session, @RequestParam("idMessage") int id) {

		Messages message1 = serviMess.findByIdMessages(id);
		System.out.println(message1.getUtilisateursByIdUtilisateurExpediteur()); // sinon ça crash......

		return new ModelAndView("FormMessageRep", "message", message1);

	}

	@Transactional
	@RequestMapping(value = "contactAnn")
	public ModelAndView ContactAnn(HttpSession session, @RequestParam("idAnnonceur") int id) {
		Messages message = new Messages();

		Login login = (Login) session.getAttribute("login");
		if (login == null) {

			return new ModelAndView("Connection", "utilisateurs", new Utilisateurs());
		}

		Utilisateurs utilisateur = serviUtili.findByIdUtilisateurs(id);
		System.out.println(utilisateur.getIdUtilisateurs());

		message.setUtilisateursByIdUtilisateurExpediteur(utilisateur);
		System.out.println(message.getUtilisateursByIdUtilisateurExpediteur());

		return new ModelAndView("FormMessageRep", "message", message);

	}

}
