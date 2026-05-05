package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	private Partita partita;
	private ComandoPosa comando;
	private IO ioFake;

	@Before
	public void setUp(){
		this.partita = new Partita();
		this.comando = new ComandoPosa();
		this.ioFake = new IO() {

			@Override
			public void mostraMessaggio(String messaggio) {}
			@Override
			public String leggiRiga() {return null;}
		};
	}

	@Test
	public void testPosaAttrezzoPresenteInBorsa() {
		Attrezzo spada = new Attrezzo("spada",1);
		this.partita.getGiocatore().getBorsa().addAttrezzo(spada);
		
		this.comando.setParametro("spada");
		this.comando.esegui(partita, ioFake);
		
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("spada"));
		
	}
	@Test
	public void testPosaAttrezzoNONPresenteInBorsa() {
		Attrezzo spada = new Attrezzo("spada",1);
		this.partita.getGiocatore().getBorsa().addAttrezzo(spada);
		
		this.comando.setParametro("osso");
		this.comando.esegui(partita, ioFake);
		
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
		
	}
	@Test
	public void testPosaAttrezzoInUnaStanzaPiena() {
		Attrezzo spada = new Attrezzo("spada",1);
		this.partita.getGiocatore().getBorsa().addAttrezzo(spada);
		
		for(int i=0; i<9; i++) {
			this.partita.getStanzaCorrente().addAttrezzo(new Attrezzo("Attrezzo"+1,1));
			
		}
		this.comando.setParametro("spada");
		this.comando.esegui(partita, ioFake);
		
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("spada"));
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
	}
	
	

}
