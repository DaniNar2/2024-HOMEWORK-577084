package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	@Test 
	public void testgetAttrezzo_StanzaVuota() {
		Stanza vuota = new Stanza("Vuota");
		assertNull(vuota.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testgetAttrezzo_StanzaNonVuota_Presente() {
		Stanza stanza1 = new Stanza("Stanza1");
		Attrezzo attrezzo = new Attrezzo("Attrezzo", 1);
		stanza1.addAttrezzo(attrezzo);
		assertNotNull(stanza1.getAttrezzo("Attrezzo"));	
	}
	
	@Test
	public void testgetAttrezzo_StanzaNonVuota_Assente() {
		Stanza stanza1 = new Stanza("Stanza1");
		Attrezzo attrezzo = new Attrezzo("Attrezzo", 1);
		stanza1.addAttrezzo(attrezzo);
		assertNull(stanza1.getAttrezzo("NonPresente"));
	}
	
	@Test
	public void testremoveAttrezzo_Presente() {
		Stanza s1 = new Stanza("Stanza1");
		Attrezzo spada = new Attrezzo("Spada", 10);
		s1.addAttrezzo(spada);
		boolean rimosso;
		rimosso= s1.removeAttrezzo(spada);
		assertTrue(rimosso);
	}
	
	@Test
	public void testremoveAttrezzo_Assente() {
		Stanza s1 = new Stanza("Stanza1");
		Attrezzo spada = new Attrezzo("Spada", 10);
		Attrezzo osso = new Attrezzo("Osso", 5);
		s1.addAttrezzo(spada);
		boolean rimosso;
		rimosso= s1.removeAttrezzo(osso);
		assertFalse(rimosso);
	}
	
	@Test 
	public void testgetStanzaAdiacente_StanzaSingola() {
		Stanza singola = new Stanza("Vuota");
		assertNull(singola.getStanzaAdiacente("inesistente"));
	}
	
	@Test
	public void testgetStanzaAdiacente_StanzaConAdiacente_Presente() {
		Stanza stanza1 = new Stanza("Stanza1");
		Stanza adiacente = new Stanza("Adiacente");
		stanza1.impostaStanzaAdiacente("nord", adiacente);
		assertNotNull(stanza1.getStanzaAdiacente("nord"));	
	}
	
	@Test
	public void testgetStanzaAdiacente_StanzaConAdiacente_Assente() {
		Stanza stanza1 = new Stanza("Stanza1");
		Stanza adiacente = new Stanza("Adiacente");
		stanza1.impostaStanzaAdiacente("nord", adiacente);
		assertNull(stanza1.getStanzaAdiacente("sud"));
	}
}
