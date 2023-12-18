package br.com.mercuryviagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mercuryviagens.domain.PacoteViagem;
import br.com.mercuryviagens.service.PacoteViagemService;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@Autowired
	private PacoteViagemService pacoteService; 
	
	@GetMapping
	public String home(Model model) {
		
		List<PacoteViagem> pacotes = pacoteService.findMostRecent(3);
		model.addAttribute("pacotes", pacotes);
		
		return "home";
	}
}
