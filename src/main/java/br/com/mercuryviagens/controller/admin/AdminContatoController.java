package br.com.mercuryviagens.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercuryviagens.domain.Contato;
import br.com.mercuryviagens.service.ContatoService;

@Controller
@RequestMapping("/admin/contatos")
public class AdminContatoController {

	@Autowired
	private ContatoService service;
		
	@GetMapping
	public ModelAndView findAll() {
		List<Contato> contatos = service.findAll();
		ModelAndView model = new ModelAndView("/admin/contato/list.html");
		model.addObject("contatos", contatos);
		return model;
	}
	
	@PostMapping
	public String save(Contato contato) {
		service.save(contato);
		return "redirect:/admin/contatos";
	}
	
	@DeleteMapping(value = "{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/contatos";
	}
}
