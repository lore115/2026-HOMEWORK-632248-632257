package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	
	private Giocatore giocatore;
	
	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
		
	}

	@Test
	public void testGiocatoreInziaCon20CFU() {
		assertEquals(20,this.giocatore.getCfu());
		
	}
	@Test
	public void testSetCfuGiocatore() {
		this.giocatore.setCfu(10);
		assertEquals(10,this.giocatore.getCfu());
	}
	@Test
	public void testOgniGiocatoreHaunaBorsa() {
		assertNotNull(this.giocatore.getBorsa());
	}
	@Test
	public void testGiocatoreIsVivo() {
		this.giocatore.setCfu(5);
		assertTrue(this.giocatore.isVivo());
	}
	@Test
	public void testGiocatoreMorto() {
		this.giocatore.setCfu(-1);
		assertFalse(this.giocatore.isVivo());
	}
}
