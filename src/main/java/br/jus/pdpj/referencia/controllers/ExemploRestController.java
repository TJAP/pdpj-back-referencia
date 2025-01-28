package br.jus.pdpj.referencia.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.pdpj.commons.annotations.PdpjApiResponses;
import br.jus.pdpj.referencia.models.dtos.ExemploDTO;
import br.jus.pdpj.referencia.models.dtos.InclusaoAlteracaoExemploDTO;
import br.jus.pdpj.referencia.services.ExemploService;
import br.jus.pdpj.starter.base.ApiVersions;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(ApiVersions.V1 + "/exemplos")
@PdpjApiResponses
public class ExemploRestController {

	private final ExemploService service;
		
	@Autowired
	public ExemploRestController(ExemploService service) {
		this.service = service;
	}
	
	@GetMapping(value = "")
	@ApiOperation(
		value = "Retorna a lista de exemplos.", 
		notes = "Retorna a lista de exemplos bla bla bla.")
	public ResponseEntity<List<ExemploDTO>> listar() {
		return ResponseEntity.ok().body(service.listar());
	}

    @PostMapping(value = "")
	@ApiOperation(
		value = "Inclui um novo exemplo.", 
		notes = "Inclui um novo exemplo bla bla bla.")
	public ResponseEntity<ExemploDTO> criar(
			@Valid
			@ApiParam(name = "dto", type = "InclusaoAlteracaoExemploDTO", value = "DTO com os dados do exemplo.", required = true)
			@RequestBody
			InclusaoAlteracaoExemploDTO dto) {
    	
		return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
	}

    @GetMapping(value = "/{id}")
	@ApiOperation(
		value = "Retorna um exemplo por seu id.", 
		notes = "Retorna um exemplo por seu id bla bla bla.")
	public ResponseEntity<ExemploDTO> getById(
			@ApiParam(name = "id", type = "Long", value = "O id do exemplo.", required = true)
			@PathVariable(name = "id")
			Long id) {
    	
		return ResponseEntity.ok().body(service.findByIdDTO(id));
	}

    @PatchMapping(value = "/{id}")
	@ApiOperation(
		value = "Edita um exemplo.", 
		notes = "Edita um exemplo bla bla bla.")
	public ResponseEntity<ExemploDTO> editar(
			@ApiParam(name = "id", type = "Long", value = "O id do exemplo.", required = true)
			@PathVariable(name = "id")
			Long id,
			
			@Valid
			@ApiParam(name = "dto", type = "InclusaoAlteracaoExemploDTO", value = "DTO com os dados do exemplo.", required = true)
			@RequestBody
			InclusaoAlteracaoExemploDTO dto) {
    	
		return ResponseEntity.ok().body(service.editar(id, dto));
	}
    
    @DeleteMapping(value = "/{id}")
	@ApiOperation(
		value = "Remove um exemplo por seu id.", 
		notes = "Remove um exemplo por seu id bla bla bla.")
	public ResponseEntity<Boolean> remover(
			@ApiParam(name = "id", type = "Long", value = "O id do exemplo.", required = true)
			@PathVariable(name = "id")
			Long id) {
    	
    	service.remover(id);
		return ResponseEntity.ok().body(true);
	}

}
