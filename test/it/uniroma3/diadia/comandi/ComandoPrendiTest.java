package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	@Test
	public void testesegui_AttrezzoPreso() {
		Labirinto l = new Labirinto();
		Partita p = new Partita(l);
		Comando c = new ComandoPrendi();
		Attrezzo spada = new Attrezzo("Spada", 1);
		
		p.getStanzaCorrente().addAttrezzo(spada);
		c.setParametro("Spada");
		c.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("Spada"));
	}
	
	@Test
	public void testesegui_AttrezzoNonPreso_Presente() {
		Labirinto l = new Labirinto();
		Partita p = new Partita(l);
		Comando c = new ComandoPrendi();
		Attrezzo spada = new Attrezzo("Spada", 1);
		
		p.getStanzaCorrente().addAttrezzo(spada);
		c.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("Spada"));
	}
	
	@Test
	public void testesegui_AttrezzoNonPreso_Assente() {
		Labirinto l = new Labirinto();
		Partita p = new Partita(l);
		Comando c = new ComandoPrendi();
		Attrezzo spada = new Attrezzo("Spada", 1);
		
		c.setParametro("Spada");
		c.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("Spada"));
	}

}

