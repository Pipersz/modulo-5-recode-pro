package br.com.mercuryviagens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercuryviagens.domain.Cliente;
import br.com.mercuryviagens.repository.ClienteRepository;
import br.com.mercuryviagens.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente findByCpf(String cpf) {
		Optional<Cliente> cliente = repo.findById(cpf);
		
		return cliente.orElseThrow(
				() -> new ObjectNotFoundException(
						"Objeto nao encontrado: " + cpf + ". Tipo: "+ Cliente.class.getName()
						)
				);
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente save(Cliente cliente) {
		return repo.save(cliente);
	}
	
	public Cliente update(Cliente cliente) {
		Cliente newCliente = findByCpf(cliente.getCpf());
		updateCliente(cliente, newCliente);
		return repo.save(newCliente);
	}
	
	public void delete(String cpf) {
		repo.deleteById(cpf);
	}
	
	private void updateCliente(Cliente oldCliente, Cliente newCliente) {
		newCliente.setEmail(oldCliente.getEmail());
		newCliente.setNome(oldCliente.getNome());
	}
}
