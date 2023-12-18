package br.com.mercuryviagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercuryviagens.domain.PacoteViagem;
import br.com.mercuryviagens.service.PacoteViagemService;

@Controller
@RequestMapping("/pacotes")
public class PacoteController {

	@Autowired
	private PacoteViagemService service;
	
	@GetMapping
	public ModelAndView list() {
		
		List<PacoteViagem> pacotes = service.findAll();
		ModelAndView model = new ModelAndView("pacotes");
		model.addObject("pacotes", pacotes);
		return model;
	}
}
