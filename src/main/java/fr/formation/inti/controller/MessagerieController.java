package fr.formation.inti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entities.Messages;
import fr.formation.inti.interfaces.services.IMessagesService;

@Controller
public class MessagerieController {

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

}
