package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	@Test
	public void testgetStanzaAdiacente_StanzaBloccata() {
		Stanza sb  = new StanzaBloccata("StanzaBloccata", "nord", "Tool");
		Stanza s = new Stanza("Stanza");
		Attrezzo sbloccante = new Attrezzo("Tool", 1);
		sb.impostaStanzaAdiacente("nord", s);
		
		assertEquals(sb, sb.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testgetStanzaAdiacente_StanzaSbloccata() {
		Stanza sb  = new StanzaBloccata("StanzaBloccata", "nord", "Tool");
		Stanza s = new Stanza("Stanza");
		Attrezzo sbloccante = new Attrezzo("Tool", 1);
		sb.impostaStanzaAdiacente("nord", s);
		
		sb.addAttrezzo(sbloccante);
		assertEquals(s, sb.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testgetDescrizione_StanzaBloccata() {
		Stanza sb  = new StanzaBloccata("StanzaBloccata", "nord", "Tool");
		Stanza s = new Stanza("Stanza");
		Attrezzo sbloccante = new Attrezzo("Tool", 1);
		sb.impostaStanzaAdiacente("nord", s);
		
		String e = "Stanza bloccata nella direzione: nord"+"\nPrendi il Tool e posalo nella stanza";
		assertEquals(e, sb.getDescrizione());
	}
	
	@Test
	public void testgetDescrizione_StanzaSbloccata() {
		Stanza sb  = new StanzaBloccata("StanzaBloccata", "nord", "Tool");
		Stanza s = new Stanza("Stanza");
		Attrezzo sbloccante = new Attrezzo("Tool", 1);
		sb.impostaStanzaAdiacente("nord", s);
		
		sb.addAttrezzo(sbloccante);
		assertEquals(sb.toString(), sb.getDescrizione());
	}

}
