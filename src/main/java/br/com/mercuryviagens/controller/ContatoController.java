package br.com.mercuryviagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercuryviagens.domain.Contato;
import br.com.mercuryviagens.service.ContatoService;

@Controller
@RequestMapping("/contato")
public class ContatoController {
	
	@Autowired
	private ContatoService service;

	@GetMapping
	public ModelAndView form() {
		
		ModelAndView model = new ModelAndView("/contato");
		model.addObject("contato", new Contato());
		return model;
	}
	
	@PostMapping
	public String sendForm(Contato contato) {
		
		service.save(contato);
		return "redirect:/contato";
		
	}
}
