package br.com.mercuryviagens.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercuryviagens.domain.Cliente;
import br.com.mercuryviagens.service.ClienteService;

@Controller
@RequestMapping("/admin/clientes")
public class AdminClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/cadastrar")
	public ModelAndView createForm() {
		Cliente cliente = new Cliente();
		ModelAndView model = new ModelAndView("admin/cliente/form");
		model.addObject("cliente", cliente);
		model.addObject("metodoHttp", "post");
		return model;
	}
	
	@GetMapping(value = "{cpf}")
	public ModelAndView updateForm(@PathVariable String cpf) {
		Cliente cliente = service.findByCpf(cpf);
		ModelAndView model = new ModelAndView("admin/cliente/form");
		model.addObject("cliente", cliente);
		model.addObject("metodoHttp", "post");
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		List<Cliente> clientes = service.findAll();
		ModelAndView model = new ModelAndView("admin/cliente/list");
		model.addObject("clientes", clientes);
		return model;
	}
	
	@PostMapping
	public String save(Cliente cliente) {
		service.save(cliente);
		return "redirect:/admin/clientes";
	}
	
	@PutMapping
	public String update(@RequestBody Cliente cliente) {
		service.update(cliente);
		return "redirect:/admin/clientes";
	}
	
	@DeleteMapping(value = "{cpf}")
	public String delete(@PathVariable String cpf) {
		service.delete(cpf);
		return "redirect:/admin/clientes";
	}
}
