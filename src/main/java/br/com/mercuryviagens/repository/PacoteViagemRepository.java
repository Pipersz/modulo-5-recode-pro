package br.com.mercuryviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercuryviagens.domain.PacoteViagem;

@Repository
public interface PacoteViagemRepository extends JpaRepository<PacoteViagem, Integer> {

}
