package br.com.mercuryviagens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercuryviagens.domain.Contato;
import br.com.mercuryviagens.repository.ContatoRepository;
import br.com.mercuryviagens.service.exception.ObjectNotFoundException;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repo;
	
	public Contato findById(Integer id) {
		Optional<Contato> contato = repo.findById(id);
		return contato.orElseThrow(
				() -> new ObjectNotFoundException("Objeto nao encontrado: "+ id + ". Tipo: "+ Contato.class.getName())
				);
	}
	
	public List<Contato> findAll() {
		return repo.findAll();
	}
	
	public Contato save(Contato contato) {
		return repo.save(contato);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	
}
