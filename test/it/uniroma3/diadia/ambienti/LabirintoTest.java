package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LabirintoTest {
	
	@Test
	public void testgetStanzaVincente() {
		Labirinto l;
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza DS1 = new Stanza("DS1");
		l = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}


	@Test
	public void testsetStanzaCorrente() {
		Labirinto l;
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza DS1 = new Stanza("DS1");
		l = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		l.setStanzaCorrente(DS1);
		
		assertEquals(DS1, l.getStanzaCorrente());
	}
	@Test
	public void testgetStanzaCorrente() {
		Labirinto l;
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza DS1 = new Stanza("DS1");
		l = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}

}
