package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {

	@Test
	public void testcostruisciComando_ComandoAssente_NonValido() {
		FabbricaDiComandiFisarmonica f = new FabbricaDiComandiFisarmonica();
		
		Comando expected = new ComandoNonValido();
		assertEquals(expected.getNome(), f.costruisciComando("nonValido").getNome());
	}
	
	@Test
	public void testcostruisciComando_ComandoPresente_ConParametro() {
		FabbricaDiComandiFisarmonica f = new FabbricaDiComandiFisarmonica();
		
		Comando expected = new ComandoVai();
		expected.setParametro("nord");
		Comando current = f.costruisciComando("vai nord");
		assertEquals(expected.getNome(), current.getNome());
		assertEquals(expected.getParametro(), current.getParametro());
	}
	
	@Test
	public void testcostruisciComando_ComandoPresente_SenzaParametro() {
		FabbricaDiComandiFisarmonica f = new FabbricaDiComandiFisarmonica();
		
		Comando expected = new ComandoFine();
		assertEquals( expected.getNome(), f.costruisciComando("fine").getNome());
	}

}
