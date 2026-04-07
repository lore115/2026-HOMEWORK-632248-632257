package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza stanzaTest;
	private Attrezzo martello;
	private Attrezzo spada;
	
	@Before
	public void setUp() {
		this.stanzaTest = new Stanza("stanzaTest");
		this.martello = new Attrezzo("martello",4);
		this.spada = new Attrezzo("spada",4);
		
	}

	@Test
	public void testAggiungiAttrezzoInUnaStanza() {
		assertTrue(this.stanzaTest.addAttrezzo(martello));
	}
	@Test
	public void testAggiungiUnAttrezzoNullo() {
		assertFalse(this.stanzaTest.addAttrezzo(null));
	}
	@Test
	public void testAggiungiPiudi10Attrezzi() {
		for(int i = 0; i < 10; i++)
		{
			assertTrue(this.stanzaTest.addAttrezzo(new Attrezzo("Attrezzo"+i,1)));
		}
		assertFalse(this.stanzaTest.addAttrezzo(new Attrezzo("Undicesimo",1)));
	}
	
	@Test
	public void testStanzaAdiacentePresente() {
		Stanza biblioteca = new Stanza("biblioteca");
		this.stanzaTest.impostaStanzaAdiacente("nord", biblioteca);
		
		assertEquals(biblioteca,this.stanzaTest.getStanzaAdiacente("nord"));
	}
	@Test
	public void testStanzaAdiacenteNonPresente() {
		assertNull(this.stanzaTest.getStanzaAdiacente("nord"));
	}
	@Test
	public void testStanzaAdiacente_Sovrascrittura() {
		Stanza biblioteca = new Stanza("biblioteca");
		Stanza cucina = new Stanza("cucina");
		
		this.stanzaTest.impostaStanzaAdiacente("nord", biblioteca);
		this.stanzaTest.impostaStanzaAdiacente("nord", cucina);
		
		assertEquals(cucina,this.stanzaTest.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaConAttrezzo() {
		this.stanzaTest.addAttrezzo(new Attrezzo("martello",2));
		
		assertTrue(this.stanzaTest.hasAttrezzo("martello"));
		
	}
	@Test
	public void testStanzaSenzaAttrezzo() {
		assertFalse(this.stanzaTest.hasAttrezzo("martello"));
	}
	
	@Test
	public void testStanzaAttrezzoMancante() {
		this.stanzaTest.addAttrezzo(new Attrezzo("spada",2));
		assertFalse(this.stanzaTest.hasAttrezzo("martello"));
	}
	
	@Test
	public void testRimuoviUnAttrezzo() {
		this.stanzaTest.addAttrezzo(spada);
		assertTrue(this.stanzaTest.removeAttrezzo(spada));
		}
	@Test
	public void testRimuoviDaStanzaVuota() {
		assertFalse(this.stanzaTest.removeAttrezzo(martello));
		}
	@Test
	public void testRimuoviFinale() {
		this.stanzaTest.addAttrezzo(martello);
		this.stanzaTest.addAttrezzo(spada);
		
		assertTrue(this.stanzaTest.removeAttrezzo(spada));
		}
	@Test
	public void testRimuoviAttrezzoAlcentro() {
		for(int i = 0; i<10 ; i++) {
			this.stanzaTest.addAttrezzo(new Attrezzo("Attrezzo"+i,1));
		}
		assertTrue(this.stanzaTest.removeAttrezzo(new Attrezzo("Attrezzo5",1)));
		assertTrue(this.stanzaTest.addAttrezzo(new Attrezzo("Nuovo", 1)));
	}
	@Test
	public void testControlloEffettivaRimorzione() {
		this.stanzaTest.addAttrezzo(spada);
		this.stanzaTest.removeAttrezzo(spada);
		
		assertFalse(this.stanzaTest.hasAttrezzo("spada"));
	}
	
	}
