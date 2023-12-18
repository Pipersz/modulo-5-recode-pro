package br.com.mercuryviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercuryviagens.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);
}
