package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IOSimulatorTest {
	
	private IOSimulator io;
	
	private void avviaPartitaSimulata(String[] comandi) {
		this.io = new IOSimulator(comandi);
		DiaDia gioco = new DiaDia(this.io);
		gioco.gioca();
	}
	
	
	
	
	@Test
	public void testPartitaVinta() {
		String[] comandi = {"vai nord"};
		avviaPartitaSimulata(comandi);
		
		assertTrue(this.io.hasMessaggio("Hai vinto!!"));
	}
	
	@Test
	public void testFinePartita() {
		String[] comandi = {"fine"};
		avviaPartitaSimulata(comandi);
		
		assertTrue(this.io.hasMessaggio("Grazie di aver giocato!"));
	}
	
	@Test
	public void testSbloccoLaStanzaCantina() {
		String[] comandi = {
				"vai ovest",
				"guarda",
				"vai est",
				"vai est",
				"prendi chiave",
				"vai ovest",
				"vai ovest",
				"posa chiave",
				"vai nord",
				"fine"
		};
		
		avviaPartitaSimulata(comandi);
		assertTrue(io.hasMessaggio("Cantina"));
	}
	
	@Test 
	public void testIlluminaCantina() {
		String[]comandi = {
				"vai est",
				"guarda",
				"prendi chiave",
				"vai est",
				"guarda",
				"posa chiave",
				"vai ovest",
				"vai ovest",
				"vai sud",
				"guarda",
				"prendi lanterna",
				"vai ovest",
				"vai nord",
				"guarda",
				"posa lanterna",
				"guarda",
				"fine"
		};
		avviaPartitaSimulata(comandi);
		assertTrue(io.hasMessaggio("kikoku"));
	}
}
