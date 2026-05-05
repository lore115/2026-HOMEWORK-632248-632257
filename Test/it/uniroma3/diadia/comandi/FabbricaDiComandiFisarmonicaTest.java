package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabbrica;
	@Before
	public void setUp() {
		this.fabbrica = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void TestComandoConParametro() {
		Comando comando = this.fabbrica.costruisciComando("vai nord");
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());	
	}
	@Test
	public void TestComandoSenzaParametro() {
		Comando comando = this.fabbrica.costruisciComando("aiuto");
		assertEquals("aiuto", comando.getNome());
		assertNull(comando.getParametro());
	}
	@Test 
	public void TestComandoNonValido() {
		Comando comando = this.fabbrica.costruisciComando("salta");
		assertEquals("comando non valido",comando.getNome());
	}
	

}
