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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercuryviagens.domain.Cliente;
import br.com.mercuryviagens.domain.PacoteViagem;
import br.com.mercuryviagens.domain.Venda;
import br.com.mercuryviagens.service.ClienteService;
import br.com.mercuryviagens.service.PacoteViagemService;
import br.com.mercuryviagens.service.VendaService;

@Controller
@RequestMapping(value = "/admin/vendas")
public class AdminVendaController {

	@Autowired
	private VendaService service;
	
	@Autowired
	private PacoteViagemService pacoteViagemService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cadastrar")
	public ModelAndView createForm() {
		List<PacoteViagem> pacotes = pacoteViagemService.findAll();
		List<Cliente> clientes = clienteService.findAll();
		ModelAndView model = new ModelAndView("/admin/venda/form");
		model.addObject("venda", new Venda());
		model.addObject("pacotes", pacotes);
		model.addObject("clientes", clientes);
		model.addObject("numMaxPrestacoes", pacotes.get(0).getNumMaxPrestacoes());
		model.addObject("metodoHttp", "post");
		return model;
	}
	
	@GetMapping(value = "{id}")
	public ModelAndView updateForm(@PathVariable Integer id) {
		Venda venda = service.findById(id);
		List<PacoteViagem> pacotes = pacoteViagemService.findAll();
		List<Cliente> clientes = clienteService.findAll();
		ModelAndView model = new ModelAndView("/admin/venda/form");
		model.addObject("venda", venda);
		model.addObject("pacotes", pacotes);
		model.addObject("clientes", clientes);
		model.addObject("numMaxPrestacoes", venda.getPacoteViagem().getNumMaxPrestacoes());
		model.addObject("metodoHttp", "put");
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		List<Venda> vendas = service.findAll();
		ModelAndView model = new ModelAndView("/admin/venda/list");
		model.addObject("vendas", vendas);
		return model;
	}
	
	@PostMapping
	public String save(Venda venda) {
		service.save(venda);
		return "redirect:/admin/vendas";
	}
	
	@PutMapping
	public String update(Venda venda) {
		service.update(venda);
		return "redirect:/admin/vendas";
	}
	
	@DeleteMapping(value = "{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/vendas";
	}
	
	@GetMapping(value = "/numPrestacoes/{idPacote}")
	public ResponseEntity<Integer> numPrestacoes (@PathVariable Integer idPacote) {
		PacoteViagem pacote = pacoteViagemService.findById(idPacote);
		return ResponseEntity.ok().body(pacote.getNumMaxPrestacoes());
	}
}
