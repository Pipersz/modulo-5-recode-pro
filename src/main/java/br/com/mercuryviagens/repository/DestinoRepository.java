package br.com.mercuryviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercuryviagens.domain.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer> {

}
