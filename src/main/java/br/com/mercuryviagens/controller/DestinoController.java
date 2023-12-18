package br.com.mercuryviagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mercuryviagens.domain.Destino;
import br.com.mercuryviagens.service.DestinoService;

@Controller
@RequestMapping("/destinos")
public class DestinoController {
	
	@Autowired
	DestinoService destinoService;

	@GetMapping
	public String destinos(Model model) {
		
		List<Destino> destinos = destinoService.findAll();
		model.addAttribute("destinos", destinos);
		
		return "destinos";
	}
}
