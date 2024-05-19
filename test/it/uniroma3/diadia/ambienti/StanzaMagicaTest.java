package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	@Test 
	public void testgetAttrezzo_StanzaVuota() {
		StanzaMagica vuota = new StanzaMagica("Vuota");
		assertNull(vuota.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testgetAttrezzo_StanzaNonVuota_Presente() {
		StanzaMagica stanza1 = new StanzaMagica("Stanza1");
		Attrezzo attrezzo = new Attrezzo("Attrezzo", 1);
		stanza1.addAttrezzo(attrezzo);
		assertNotNull(stanza1.getAttrezzo("Attrezzo"));	
	}
	
	@Test
	public void testgetAttrezzo_StanzaNonVuota_Assente() {
		StanzaMagica stanza1 = new StanzaMagica("Stanza1");
		Attrezzo attrezzo = new Attrezzo("Attrezzo", 1);
		stanza1.addAttrezzo(attrezzo);
		assertNull(stanza1.getAttrezzo("NonPresente"));
	}
	
	@Test
	public void testremoveAttrezzo_Presente() {
		StanzaMagica s1 = new StanzaMagica("Stanza1");
		Attrezzo spada = new Attrezzo("Spada", 10);
		s1.addAttrezzo(spada);
		boolean rimosso;
		rimosso= s1.removeAttrezzo(spada);
		assertTrue(rimosso);
	}
	
	@Test 
	public void testgetStanzaAdiacente_StanzaSingola() {
		StanzaMagica singola = new StanzaMagica("Vuota");
		assertNull(singola.getStanzaAdiacente("inesistente"));
	}
	
	@Test
	public void testgetStanzaAdiacente_StanzaConAdiacente_Presente() {
		StanzaMagica stanza1 = new StanzaMagica("Stanza1");
		StanzaMagica adiacente = new StanzaMagica("Adiacente");
		stanza1.impostaStanzaAdiacente("nord", adiacente);
		assertNotNull(stanza1.getStanzaAdiacente("nord"));	
	}
	
	@Test
	public void testgetStanzaAdiacente_StanzaConAdiacente_Assente() {
		StanzaMagica stanza1 = new StanzaMagica("Stanza1");
		StanzaMagica adiacente = new StanzaMagica("Adiacente");
		stanza1.impostaStanzaAdiacente("nord", adiacente);
		assertNull(stanza1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testmodificaAttrezzo() {
		StanzaMagica s = new StanzaMagica("Stanza");
		Attrezzo spada = new Attrezzo("Spada", 3);
		s.addAttrezzo(spada);
		Attrezzo modificato = s.modificaAttrezzo(spada);
		assertEquals("adapS", modificato.getNome());
		assertEquals(6, modificato.getPeso());
	}
	
	
}
