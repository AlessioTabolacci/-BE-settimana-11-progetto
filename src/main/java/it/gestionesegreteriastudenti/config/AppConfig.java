package it.gestionesegreteriastudenti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.gestionesegreteriastudenti.model.CorsoLaurea;
import it.gestionesegreteriastudenti.model.DummyDB;
import it.gestionesegreteriastudenti.model.Studente;

@Configuration
public class AppConfig {

	@Bean
	public DummyDB dummyDb() {
		return new DummyDB();
	}

	@Bean
	@Scope("prototype")
	public CorsoLaurea corso() {
		return new CorsoLaurea();
	}

	@Bean
	@Scope("prototype")
	public Studente studente() {
		return new Studente();
	}
}
