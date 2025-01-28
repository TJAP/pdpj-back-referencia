package br.jus.pdpj.referencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.pdpj.referencia.models.entities.LogEndpoint;
import br.jus.pdpj.referencia.repositories.LogEndpointRepository;

@Service
public class LogEndpointService {

	private final LogEndpointRepository repository;
	
	@Autowired
	public LogEndpointService(LogEndpointRepository repository) {
		this.repository = repository;
	}
	
	public void salvar(LogEndpoint trace) {
		repository.save(trace);
	}
}
