package br.com.mercuryviagens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercuryviagens.domain.Venda;
import br.com.mercuryviagens.repository.VendaRepository;
import br.com.mercuryviagens.service.exception.ObjectNotFoundException;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repo; 
	
	public Venda findById(Integer id) {
		Optional<Venda> venda = repo.findById(id);
		return venda.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado: "+ id + ". Tipo: "+ Venda.class.getName()));
	}
	
	public List<Venda> findAll() {
		return repo.findAll();
	}
	
	public Venda save(Venda venda) {
		return repo.save(venda);
	}
	
	public Venda update(Venda venda) {
		Venda newVenda = findById(venda.getId());
		updateVenda(venda, newVenda);
		return repo.save(venda);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	private Venda updateVenda(Venda oldVenda, Venda newVenda) {
		newVenda.setNumPrestacoes(oldVenda.getNumPrestacoes());
		newVenda.setCliente(oldVenda.getCliente());
		newVenda.setPacoteViagem(oldVenda.getPacoteViagem());
		return newVenda;
	}
}
