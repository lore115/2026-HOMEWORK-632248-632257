package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia stanza;
	private Attrezzo lanterna;

	@Before
	public void setUp(){
		this.stanza = new StanzaBuia("Cantina","lanterna");
		this.lanterna = new Attrezzo("lanterna",1);
	}

	@Test
	public void testStanzaBuiaConLanterna() {
		this.stanza.addAttrezzo(lanterna);
		String descrizioneNormale = this.stanza.getDescrizione();
		
		
		assertTrue(descrizioneNormale.contains("Cantina"));
	}
	@Test 
	public void testStanzaBuiaSenzaLanterna() {
		String messaggio = "qui c'è un buio pesto ";
		
		assertEquals(messaggio,this.stanza.getDescrizione());
	}
	@Test
	public void testStanzaBuiaConOgettoSbagliato() {
		Attrezzo osso = new Attrezzo("osso",1);
		this.stanza.addAttrezzo(osso);
		
		assertEquals("qui c'è un buio pesto ",this.stanza.getDescrizione());
		
	}

}
