package br.com.mercuryviagens.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercuryviagens.domain.Destino;
import br.com.mercuryviagens.domain.Imagem;
import br.com.mercuryviagens.service.DestinoService;

@Controller
@RequestMapping("/admin/destinos")
public class AdminDestinoController {
	
	@Autowired
	private DestinoService service;

	@GetMapping(value = "{id}")
	public ModelAndView findById(@PathVariable Integer id) {
		Destino destino = service.findById(id);
		ModelAndView model = new ModelAndView("admin/destino/form");
		model.addObject("destino", destino);
		model.addObject("metodoHttp", "put");
		return model;
	}

	@GetMapping
	public ModelAndView findAll() {
		List<Destino> destinos = service.findAll();
		ModelAndView model = new ModelAndView("/admin/destino/list");
		model.addObject("destinos", destinos);
		return model;
	}

	@PostMapping
	public String save(Destino destino, 
			@RequestParam("imagensUpload") MultipartFile[] files) throws IOException {
		
		List<Imagem> imagens = new ArrayList<Imagem>();
		
		for (MultipartFile file : files) {
			
			Imagem imagem = new Imagem(null, file.getOriginalFilename(), file.getBytes());
			imagens.add(imagem);
		}
		
		destino.addImagens(imagens);
		service.save(destino);
		return "redirect:/admin/destinos";
	}
	
	@PutMapping()
	public String update(Destino destino,
			@RequestParam("imagensUpload") MultipartFile[] files) throws IOException {
		
		List<Imagem> imagens = new ArrayList<Imagem>();
		
		for (MultipartFile file : files) {
			
			String name = file.getOriginalFilename();
			if (name.isEmpty()) {
				continue;
			}
			
			Imagem imagem = new Imagem(null, name, file.getBytes());
			imagens.add(imagem);
		}
		
		destino.addImagens(imagens);		
		service.update(destino);
		return "redirect:/admin/destinos";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/destinos";
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView showForm() {
		ModelAndView model = new ModelAndView("/admin/destino/form");
		model.addObject("destino", new Destino());
		model.addObject("metodoHttp", "post");
		return model;
	}
}
