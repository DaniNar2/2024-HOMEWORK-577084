package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {

	@Test
	public void testsetCfu() {
		Giocatore g = new Giocatore();
		g.setCfu(15);
		assertEquals(15, g.getCfu());
	}
	
	@Test
	public void testgetCfu_Presenti() {
		Giocatore g = new Giocatore();
		g.setCfu(10);
		assertEquals(10, g.getCfu());
	}
	
	@Test
	public void testgetCfu_Assenti() {
		Giocatore g = new Giocatore();
		assertEquals(0, g.getCfu());
	}
	
	@Test
	public void testsetBorsa() {
		Giocatore g = new Giocatore();
		Borsa b = new Borsa();
		g.setBorsa(b);
		assertNotNull(g.getBorsa());
	}
	
	@Test 
	public void testgetBorsa_Presente() {
		Giocatore g = new Giocatore();
		Borsa b = new Borsa();
		g.setBorsa(b);
		assertNotNull(g.getBorsa());
		
	}
	
	@Test 
	public void testgetBorsa_Assente() {
		Giocatore g = new Giocatore();
		assertNull(g.getBorsa());
		
	}
}
