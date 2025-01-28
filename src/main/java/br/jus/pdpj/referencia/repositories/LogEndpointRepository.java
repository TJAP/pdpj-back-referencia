package br.jus.pdpj.referencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.pdpj.referencia.models.entities.LogEndpoint;

public interface LogEndpointRepository extends JpaRepository<LogEndpoint, Long> {
	
}
