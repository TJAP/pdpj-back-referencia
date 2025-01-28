package br.jus.pdpj.referencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.pdpj.referencia.models.entities.Exemplo;

public interface ExemploRepository extends JpaRepository<Exemplo, Long> {

	Exemplo findByNome(String username);
	
}
