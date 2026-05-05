package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private StanzaMagica stanza;
	private Attrezzo osso;
	private Attrezzo lanterna;
	private Attrezzo spada;
	private Attrezzo bastone;

	@Before
	public void setUp() {
		this.stanza = new StanzaMagica("StanzaMagica");
		
		this.osso = new Attrezzo("osso", 1);
		this.lanterna = new Attrezzo("lanterna", 2);
		this.spada = new Attrezzo("spada", 3);
		this.bastone = new Attrezzo("bastone", 4);
	}

	@Test
	public void testAddAttrezzoPrimaDellaSoglia() {
		this.stanza.addAttrezzo(this.osso); 
		
		assertTrue(this.stanza.hasAttrezzo("osso"));
		assertEquals(1, this.stanza.getAttrezzo("osso").getPeso());
	}
	
	@Test
	public void testAddAttrezzoSullaSoglia() {
		this.stanza.addAttrezzo(this.osso);
		this.stanza.addAttrezzo(this.lanterna);
		this.stanza.addAttrezzo(this.spada); 
		
		assertTrue(this.stanza.hasAttrezzo("spada"));
	}

	@Test
	public void testAddAttrezzoSogliaMagicaSuperata() {
		
		this.stanza.addAttrezzo(this.osso);
		this.stanza.addAttrezzo(this.lanterna);
		this.stanza.addAttrezzo(this.spada);
		
		
		this.stanza.addAttrezzo(this.bastone); 
		
		
		assertFalse(this.stanza.hasAttrezzo("bastone"));
		
		
		assertTrue(this.stanza.hasAttrezzo("enotsab"));
		
		
		assertEquals(8, this.stanza.getAttrezzo("enotsab").getPeso());
	}
	
	@Test
	public void testSogliaMagicaPersonalizzata() {
		
		StanzaMagica stanzaSpeciale = new StanzaMagica("StanzaSpeciale", 1);
		
		stanzaSpeciale.addAttrezzo(this.osso); 
		assertTrue(stanzaSpeciale.hasAttrezzo("osso"));
		
		stanzaSpeciale.addAttrezzo(this.lanterna); 
		
		assertFalse(stanzaSpeciale.hasAttrezzo("lanterna"));
		assertTrue(stanzaSpeciale.hasAttrezzo("anretnal"));
		assertEquals(4, stanzaSpeciale.getAttrezzo("anretnal").getPeso());
	}

}