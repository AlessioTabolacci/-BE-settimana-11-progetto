package it.gestionesegreteriastudenti.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DummyDB {

	private final Map<String, Studente> studenti = new HashMap<>();
	private final Map<String, CorsoLaurea> corsi = new HashMap<>();

	public Collection<Studente> getAllStudenti() {
		return studenti.values();
	}

	public Collection<CorsoLaurea> getAllCorsi(){
		return corsi.values();
	}

	public void aggiungiStudente(Studente s) {
		studenti.put(s.getMatricola(), s);
	}

	public void eliminaStudente(String matricola) {
		studenti.remove(matricola);
	}

	public void aggiornaStudente(Studente s) {
		studenti.put(s.getMatricola(), s);
	}

	public void aggiungiCorso(CorsoLaurea corso) {
		corsi.put(corso.getCodice(), corso);
	}

	public Studente getStudenteByMatricola(String matricola) {
		return studenti.get(matricola);
	}

	public CorsoLaurea getCorsoByCodice(String codice) {
		return corsi.get(codice);
	}
}
