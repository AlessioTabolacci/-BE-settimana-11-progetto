package it.gestionesegreteriastudenti.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.gestionesegreteriastudenti.model.CorsoLaurea;
import it.gestionesegreteriastudenti.model.DummyDB;
import it.gestionesegreteriastudenti.model.Studente;

@Component
public class DummyDBLoader implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		DummyDB dummyDb = ctx.getBean(DummyDB.class);
		valorizzaDb(dummyDb);
	}

	public void valorizzaDb(DummyDB db) {
		CorsoLaurea c1 = CorsoLaurea.builder().codice("A10").nome("Informatica").indirizzo("Via Roma 10").numeroEsami(15).build();
		CorsoLaurea c2 = CorsoLaurea.builder().codice("A20").nome("Matematica").indirizzo("Via della vasca navale 58").numeroEsami(25).build();
		CorsoLaurea c3 = CorsoLaurea.builder().codice("B56").nome("D.A.M.S.").indirizzo("Via Ostiense 100").numeroEsami(36).build();
		CorsoLaurea c4 = CorsoLaurea.builder().codice("F58").nome("Psicologia").indirizzo("Viale Marconi 500").numeroEsami(40).build();
		CorsoLaurea c5 = CorsoLaurea.builder().codice("G89").nome("Fisica").indirizzo("Viale dei romanisti 221").numeroEsami(36).build();
		Studente s1 = Studente.builder().matricola("AA569X").nome("Marco").cognome("Rossi").dataNascita(LocalDate.parse("1987-03-16")).email("m.rossi@gmail.com").indirizzo("Via Roma 10").citta("Palermo").corsoLaurea(c3).build();
		Studente s2 = Studente.builder().matricola("AA522D").nome("Alessio").cognome("Tabolacci").dataNascita(LocalDate.parse("1989-05-14")).email("alessio.tabolacci@hotmail.com").indirizzo("Via Roberto de nobili 5").citta("Roma").corsoLaurea(c5).build();
		Studente s3 = Studente.builder().matricola("BB897XS").nome("Simone").cognome("Guidi").dataNascita(LocalDate.parse("1992-04-22")).email("s.guidi@email.it").indirizzo("Via le mani dal naso 56").citta("Genova").corsoLaurea(c1).build();
		Studente s4 = Studente.builder().matricola("DF854LK").nome("Pasquale").cognome("Torcasio").dataNascita(LocalDate.parse("1996-04-29")).email("calabria@calabria.it").indirizzo("Via Calabria 20").citta("Belluno").corsoLaurea(c2).build();
		Studente s5 = Studente.builder().matricola("LP874CS").nome("Antonello").cognome("Pagnozzi").dataNascita(LocalDate.parse("1992-09-12")).email("a.pagnozzi@libero.it").indirizzo("Via della magliana 120").citta("Roma").corsoLaurea(c4).build();
		db.aggiungiStudente(s1);
		db.aggiungiStudente(s2);
		db.aggiungiStudente(s3);
		db.aggiungiStudente(s4);
		db.aggiungiStudente(s5);
		db.aggiungiCorso(c1);
		db.aggiungiCorso(c2);
		db.aggiungiCorso(c3);
		db.aggiungiCorso(c4);
		db.aggiungiCorso(c5);
	}

}
