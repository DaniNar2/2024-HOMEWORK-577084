package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {

	@Test
	public void testgetLabirinto() {
		LabirintoBuilder lb = new LabirintoBuilder();
		
		assertNotNull(lb.getLabirinto());
		assertEquals(Labirinto.class, lb.getLabirinto().getClass());
	}

	@Test
	public void testaddStanza() {
		LabirintoBuilder lb = new LabirintoBuilder();
		lb.addStanza("stanzetta");
		Stanza expected = new Stanza("stanzetta");
		
		assertEquals(expected, lb.getNome2stanza().get("stanzetta"));
	}

	@Test
    public void testaddAttrezzo_ConStanza() {
		LabirintoBuilder lb = new LabirintoBuilder();
        lb.addStanza("stanzetta");
        lb.addAttrezzo("cacciavite", 3);
        
        assertTrue(lb.getNome2stanza().get("stanzetta").hasAttrezzo("cacciavite"));
    }
}


