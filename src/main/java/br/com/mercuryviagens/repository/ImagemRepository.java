package br.com.mercuryviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercuryviagens.domain.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Integer> {

}
