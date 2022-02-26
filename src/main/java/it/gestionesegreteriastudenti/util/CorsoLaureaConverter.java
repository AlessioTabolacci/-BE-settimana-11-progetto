package it.gestionesegreteriastudenti.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.gestionesegreteriastudenti.model.CorsoLaurea;
import it.gestionesegreteriastudenti.model.DummyDB;

@Component
public class CorsoLaureaConverter implements Converter<String, CorsoLaurea> {
	@Autowired
	ApplicationContext ctx;

	public DummyDB getDummyDb() {
		return ctx.getBean(DummyDB.class);
	}
	@Override
	public CorsoLaurea convert(String codice) {
		return ctx.getBean(DummyDB.class).getCorsoByCodice(codice);

	}

}
