package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonicaTest {

	@Test
	public void testcostruisciComando_NonValido() {
		IO io = new IOConsole();
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica(io);
		Comando expected = new ComandoNonValido();

		assertEquals( expected.getNome(), fabbrica.costruisciComando("pippo").getNome());
	}
	
	@Test
	public void testcostruisciComando_ConParametro() {
		IO io = new IOConsole();
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica(io);
		Comando expected = new ComandoVai();
		expected.setParametro("nord");
		Comando current = fabbrica.costruisciComando("vai nord");
		
		assertEquals( expected.getNome(), current.getNome());
		assertEquals( expected.getParametro(), current.getParametro());
	}
	
	@Test
	public void testcostruisciComando_SenzaParametro() {
		IO io = new IOConsole();
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica(io);
		Comando expected = new ComandoFine();
		
		assertEquals( expected.getNome(), fabbrica.costruisciComando("fine").getNome());
	}

}
