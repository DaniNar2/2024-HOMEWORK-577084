package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {

	@Test
	public void testvinta_Vinta() {
		
		boolean vinta;
		Labirinto labirinto = new Labirinto();
		Partita p = new Partita(labirinto);
		Stanza vincente = labirinto.getStanzaVincente();
		Stanza corrente = vincente;
		p.setStanzaCorrente(corrente);
		vinta = p.vinta();
		assertTrue(vinta);
		
	}
	
	@Test
	public void testvinta_NonVinta() {
		
		boolean vinta;
		Labirinto labirinto = new Labirinto();
		Partita p = new Partita(labirinto);
		Stanza corrente = new Stanza("Corrente");
		p.setStanzaCorrente(corrente);
		vinta = p.vinta();
		assertFalse(vinta);
	}
	
	@Test
	public void testsetStanzaCorrente() {
		Labirinto l = new Labirinto();
		Partita p = new Partita(l);
		Stanza DS1 = new Stanza("DS1");
		p.setStanzaCorrente(DS1);
		assertEquals(DS1, p.getStanzaCorrente());
	}
	
	@Test
	public void testgetStanzaCorrente() {
		Labirinto l = new Labirinto();
		Partita p = new Partita(l);
		assertEquals("Atrio", p.getStanzaCorrente().getNome());
	}
}
