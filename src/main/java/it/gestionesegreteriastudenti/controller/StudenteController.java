package it.gestionesegreteriastudenti.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.gestionesegreteriastudenti.model.CorsoLaurea;
import it.gestionesegreteriastudenti.model.DummyDB;
import it.gestionesegreteriastudenti.model.Studente;

@Controller
@RequestMapping("/studenti")
public class StudenteController {

	@Autowired
	ApplicationContext ctx;

	public DummyDB getDummyDb() {
		return ctx.getBean(DummyDB.class);
	}

	@GetMapping("/visualizzastudenti")	
	public ModelAndView visualizzaStudenti() {

		return new ModelAndView("visualizzaStudenti", "studenti", getDummyDb().getAllStudenti());	

	}

	@GetMapping("/mostraform")
	public ModelAndView mostraForm(Studente studente) {
		ModelAndView mav = new ModelAndView("aggiungiStudente");
		Collection<CorsoLaurea> corsi = getDummyDb().getAllCorsi();
		mav.addObject("studente", studente);
		mav.addObject("corsi", corsi);
		return mav;

	}

	@PostMapping("/aggiungistudente")
	public ModelAndView aggiungiStudente(Studente studente, BindingResult result, Model model) {



		getDummyDb().aggiungiStudente(studente);

		
		return new ModelAndView("visualizzaStudenti", "studenti", getDummyDb().getAllStudenti());
	}
	
}