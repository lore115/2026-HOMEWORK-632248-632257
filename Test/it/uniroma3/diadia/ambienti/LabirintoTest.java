package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	private Labirinto LabTest;
	
	@Before
	public void setUp() {
		this.LabTest = new Labirinto();
		
	}

	@Test
	public void testStanzaIniziale() {
		assertEquals("Atrio",this.LabTest.getStanzaIniziale().getNome());
		
	}
	@Test
	public void testStanzaFinale() {
		assertEquals("Biblioteca",this.LabTest.getStanzaFinale().getNome());
		
	}

}
