package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {

	@Test
	public void testesegui_AttrezzoPosato() {
		Labirinto l = new Labirinto();
		Partita p = new Partita(l);
		Comando c = new ComandoPosa();
		Attrezzo spada = new Attrezzo("Spada", 1);
		
		p.getGiocatore().getBorsa().addAttrezzo(spada);
		c.setParametro("Spada");
		c.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("Spada"));
	}
	
	@Test
	public void testesegui_AttrezzoNonPosato_Presente() {
		Labirinto l = new Labirinto();
		Partita p = new Partita(l);
		Comando c = new ComandoPosa();
		Attrezzo spada = new Attrezzo("Spada", 1);
		
		p.getGiocatore().getBorsa().addAttrezzo(spada);
		c.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("Spada"));
	}
	
	@Test
	public void testesegui_AttrezzoPosato_Assente() {
		Labirinto l = new Labirinto();
		Partita p = new Partita(l);
		Comando c = new ComandoPosa();
		Attrezzo spada = new Attrezzo("Spada", 1);
		
		c.setParametro("Spada");
		c.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("Spada"));
	}

}
