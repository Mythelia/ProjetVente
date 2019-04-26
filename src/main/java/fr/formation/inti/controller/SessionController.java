package fr.formation.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.formation.inti.Entities.Utilisateurs;

@Controller
@SessionAttributes("user")
public class SessionController {
	
	   @ModelAttribute("user")
	   public Utilisateurs setUpUserForm() {
	      return new Utilisateurs();
	   }
	   

}
