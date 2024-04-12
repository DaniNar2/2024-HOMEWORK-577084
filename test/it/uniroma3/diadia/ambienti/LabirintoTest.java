package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;

public class LabirintoTest {

	@Test
	public void testgetStanzaIniziale() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testgetStanzaVincente() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
}
