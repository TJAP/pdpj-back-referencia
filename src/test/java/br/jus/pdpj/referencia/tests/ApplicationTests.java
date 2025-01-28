package br.jus.pdpj.referencia.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.jus.pdpj.referencia.models.dtos.ExemploDTO;
import br.jus.pdpj.referencia.services.ExemploService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ApplicationTests extends AbstractIntegrationTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Autowired
	private ExemploService service;
	
	@Test
	void contextLoads() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void tentarObterProcessoSemLogin() {
		ResponseEntity<ExemploDTO> resposta = testRestTemplate.getForEntity(getLocalhost()+"exemplos", null, ExemploDTO.class);
		assertThat(resposta.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	}
	
	private String getLocalhost() {
		return "http://localhost:"+this.port+"/";
	}
}


