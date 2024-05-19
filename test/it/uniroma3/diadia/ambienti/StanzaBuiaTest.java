package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	@Test
	public void testgetDescrizione_StanzaNonIlluminata() {
		Stanza buia = new StanzaBuia("StanzaBuia", "Torcia");
		Attrezzo luce = new Attrezzo("Torcia", 2);
		
		String e = "Qui c'è un buio pesto";
		assertEquals(e, buia.getDescrizione());
	}
	
	@Test
	public void testgetDescrizione_StanzaIlluminata() {
		Stanza buia = new StanzaBuia("StanzaBuia", "Torcia");
		Attrezzo luce = new Attrezzo("Torcia", 2);
		
		buia.addAttrezzo(luce);
		assertEquals(buia.toString(), buia.getDescrizione());
	}

}
