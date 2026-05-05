package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	private Partita partita;
	private IO ioFake;
	private ComandoPrendi comando;
	
	@Before
	public void setUp(){
		this.partita = new Partita();
		this.comando = new ComandoPrendi();
		this.ioFake = new IO() {

			@Override
			public void mostraMessaggio(String messaggio) {}
			@Override
			public String leggiRiga() {return null;}
		};
	}

	@Test
	public void testPrendiAttrezzoPresente() {
		Attrezzo spada = new Attrezzo("spada",2);
		this.partita.getStanzaCorrente().addAttrezzo(spada);
		
		this.comando.setParametro("spada");
		this.comando.esegui(this.partita, this.ioFake);
		
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("spada"));
		
	}
	@Test
	public void testPrendiAttrezzoAssente() {
		Attrezzo spada = new Attrezzo("spada",2);
		this.partita.getStanzaCorrente().addAttrezzo(spada);
		
		this.comando.setParametro("lanterna");
		this.comando.esegui(this.partita, this.ioFake);
		
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("spada"));
		
	}
	@Test
	public void testPrendiMaBorsaPiena() {
		Attrezzo spada = new Attrezzo("spada",1);
		this.partita.getStanzaCorrente().addAttrezzo(spada);
		
		for(int i = 0; i < 10 ; i++) {
			this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("Attrezzo"+i,1));
		}
		this.comando.setParametro("spada");
		this.comando.esegui(this.partita, this.ioFake);
		
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("spada"));
	}
	
	

}
