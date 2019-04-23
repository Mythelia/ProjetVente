package fr.formation.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerImage {

	@RequestMapping(value = "/img")
	public String handleRequest(Model model) {
		System.out.println("test");
		return "Quisommesnous";
	}
}
