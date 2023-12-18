package br.com.mercuryviagens.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercuryviagens.domain.Destino;
import br.com.mercuryviagens.domain.PacoteViagem;
import br.com.mercuryviagens.service.DestinoService;
import br.com.mercuryviagens.service.PacoteViagemService;

@Controller
@RequestMapping(value = "/admin/pacotes")
public class AdminPacoteViagemController {

	@Autowired
	private PacoteViagemService service;
	
	@Autowired
	private DestinoService destinoService;
	
	@GetMapping(value = "/cadastrar")
	public ModelAndView createForm() {
		PacoteViagem pacoteViagem = new PacoteViagem();
		List<Destino> destinos = destinoService.findAll();
		ModelAndView model = new ModelAndView("/admin/pacote-viagem/form");
		model.addObject("pacoteViagem", pacoteViagem);
		model.addObject("destinos", destinos);
		model.addObject("metodoHttp", "post");
		return model;
	}
	
	@GetMapping(value = "{id}")
	public ModelAndView findById(@PathVariable Integer id) {
		
		PacoteViagem pacoteViagem = service.findById(id);
		List<Destino> destinos = destinoService.findAll();
		ModelAndView model = new ModelAndView("/admin/pacote-viagem/form");
		model.addObject("pacoteViagem", pacoteViagem);
		model.addObject("destinos", destinos);
		model.addObject("metodoHttp", "put");
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		List<PacoteViagem> pacotes = service.findAll();
		ModelAndView model = new ModelAndView("/admin/pacote-viagem/list");
		model.addObject("pacotesViagens", pacotes);
		return model;
	}
	
	@PostMapping
	public String save(PacoteViagem pacoteViagem) {
		service.save(pacoteViagem);
		return "redirect:/admin/pacotes";
	}
	
	@PutMapping
	public String update(PacoteViagem pacoteViagem) {
		service.update(pacoteViagem);
		return "redirect:/admin/pacotes"; 
	}
	
	@DeleteMapping(value = "{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/pacotes";
	}
}
