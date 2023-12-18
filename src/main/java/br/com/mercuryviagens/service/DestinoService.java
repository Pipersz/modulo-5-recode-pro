package br.com.mercuryviagens.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercuryviagens.domain.Destino;
import br.com.mercuryviagens.domain.Imagem;
import br.com.mercuryviagens.repository.DestinoRepository;
import br.com.mercuryviagens.repository.ImagemRepository;
import br.com.mercuryviagens.service.exception.ObjectNotFoundException;

@Service
public class DestinoService {

	@Autowired
	private DestinoRepository repo;
	
	@Autowired
	private ImagemRepository imagemRepo;
	
	public Destino findById(Integer id) {
		Optional<Destino> destino = repo.findById(id);
		return destino.orElseThrow(
				() -> new ObjectNotFoundException(
						"Objeto nao encontrado: "+ id + ". Tipo: "+ Destino.class.getName()
						)
				);
	}
	
	public List<Destino> findAll() {
		return repo.findAll();
	}
	
	public Destino save(Destino destino) {
		
		return repo.save(destino);
	}
	
	public Destino update(Destino destino) {
		Destino newDestino = findById(destino.getId());
		updateDestino(destino, newDestino);
		return repo.save(newDestino);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	private Destino updateDestino(Destino oldDestino, Destino newDestino) {
		newDestino.setNome(oldDestino.getNome());
		newDestino.setDescricao(oldDestino.getDescricao());
		newDestino.clearImagens();
		newDestino.addImagens(oldDestino.getImagens());
		return newDestino;
	}
}
