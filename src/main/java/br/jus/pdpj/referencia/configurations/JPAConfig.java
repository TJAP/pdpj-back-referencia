package br.jus.pdpj.referencia.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.jus.pdpj.starter.base.BaseRepository;

@Configuration
@EnableJpaRepositories(
    basePackages = {"br.jus.pdpj.referencia.base","br.jus.pdpj.referencia.repositories"}, 
    repositoryBaseClass = BaseRepository.class,
    repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@EntityScan(basePackages = {"br.jus.pdpj.referencia.models.entities"})
public class JPAConfig {

}
