package br.jus.pdpj.referencia.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.jus.pdpj.referencia.auditoria.ContentTrace;
import br.jus.pdpj.referencia.models.entities.LogEndpoint;

@Mapper(componentModel="spring")
public interface LogEndpointMapper {
	
	@Mapping(target = "id", ignore = true)
    public abstract LogEndpoint toEntity(ContentTrace model);

}
