package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class BorsaTest {

	@Test
	public void testaddAttrezzo_BorsaVuota() {
		Borsa b = new Borsa();
		Attrezzo spada = new Attrezzo("Spada", 5);
		assertTrue(b.addAttrezzo(spada));
	}
	
	@Test
	public void testaddAttrezzo_BorsaNonVuota_Aggiunto() {
		Borsa b = new Borsa();
		Attrezzo spada = new Attrezzo("Spada", 5);
		Attrezzo osso = new Attrezzo("Osso", 3);
		b.addAttrezzo(spada);
		assertTrue(b.addAttrezzo(osso));
	}
	
	@Test
	public void testaddAttrezzo_BorsaNonVuota_NonAggiunto() {
		Borsa b = new Borsa();
		Attrezzo spada = new Attrezzo("Spada", 8);
		Attrezzo osso = new Attrezzo("Osso", 3);
		b.addAttrezzo(spada);
		assertFalse(b.addAttrezzo(osso));
	}
	
	@Test 
	public void testgetAttrezzo_BorsaVuota() {
		Borsa bVuota = new Borsa();
		assertNull(bVuota.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testgetAttrezzo_BorsaNonVuota_Presente() {
		Borsa b1 = new Borsa();
		Attrezzo spada = new Attrezzo("Spada", 1);
		b1.addAttrezzo(spada);
		assertNotNull(b1.getAttrezzo("Spada"));	
	}
	
	@Test
	public void testgetAttrezzo_BorsaNonVuota_Assente() {
		Borsa b2 = new Borsa();
		Attrezzo spada = new Attrezzo("Spada", 1);
		b2.addAttrezzo(spada);
		assertNull(b2.getAttrezzo("NonPresente"));
	}
	
	@Test
	public void testisEmpty_BorsaVuota() {
		Borsa vuota = new Borsa();
		assertTrue(vuota.isEmpty());
	}
	
	@Test
	public void testisEmpty_BorsaNonVuota() {
		Borsa b = new Borsa();
		Attrezzo spada = new Attrezzo("Spada", 5);
		b.addAttrezzo(spada);
		assertFalse(b.isEmpty());
	}
	
	@Test
	public void testremoveAttrezzo_BorsaVuota() {
		Borsa b = new Borsa();
		b.removeAttrezzo("NonPresente");
	}
	
	@Test
	public void testremoveAttrezzo_BorsaNonVuota() {
		Borsa b = new Borsa();
		Attrezzo attrezzo = new Attrezzo("Attrezzo", 3);
		b.removeAttrezzo("Attrezzo");
	}
	
	@Test
	public void testgetSortedSet_OrdinatoPerPeso_AttrezziStessoPeso() {
		Borsa b = new Borsa();
		Attrezzo falce = new Attrezzo("Falce", 2);
		Attrezzo martello = new Attrezzo("Martello", 2);
		b.addAttrezzo(falce);
		b.addAttrezzo(martello);
		Set<Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		expected.add(falce);
		expected.add(martello);
		assertArrayEquals(expected.toArray(), b.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testgetContenuto_OrdinatoPerPeso_StessoPeso() {
		Borsa b = new Borsa();
		Attrezzo falce = new Attrezzo("Falce", 2);
		Attrezzo martello = new Attrezzo("Martello", 2);
		b.addAttrezzo(martello);
		b.addAttrezzo(falce);
		List<Attrezzo> ex = new ArrayList<>();
		ex.add(falce);
		ex.add(martello);
		assertTrue(this.controllaList(ex, b.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testgetContenuto_OrdinatoPerPeso_PesiDiversi() {
		Borsa b = new Borsa();
		Attrezzo computer = new Attrezzo("Computer", 2);
		Attrezzo laptop = new Attrezzo("Laptop", 4);
		b.addAttrezzo(computer);
		b.addAttrezzo(laptop);
		List<Attrezzo> ex = new ArrayList<>();
		ex.add(computer);
		ex.add(laptop);
		assertTrue(this.controllaList(ex, b.getContenutoOrdinatoPerPeso()));
	}	
	public boolean controllaList(List<?> c1, List<?> c2) {
		if(c1.size()!=c2.size())
			return false;
		for(int i = 0; i<c1.size(); i++ ) {
			if(!c1.get(i).equals(c2.get(i)) )
				return false;
		}
		return true;
	}
	
}

