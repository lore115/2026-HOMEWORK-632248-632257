package it.uniroma3.diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	private Partita partita;
	private Stanza stanzaTest;
	@Before
	public void setUp(){
		this.partita = new Partita();
		this.stanzaTest = new Stanza("stanzaTest");
	}

	@Test
	public void testStanzaVincente_PartitaVinta() {
		this.stanzaTest = this.partita.getLabirinto().getStanzaFinale();
		this.partita.setStanzaCorrente(this.stanzaTest);
		
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testStanzaNonVincente_PartitaPersa() {
		this.partita.setStanzaCorrente(this.stanzaTest);
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testVerificaStanzaInizialeNonVince() {
		this.stanzaTest = this.partita.getLabirinto().getStanzaIniziale();
		this.partita.setStanzaCorrente(this.stanzaTest);
		assertFalse(this.partita.vinta());
	}
	@Test
	public void testFinePartitaCfuAzzerati() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
}
