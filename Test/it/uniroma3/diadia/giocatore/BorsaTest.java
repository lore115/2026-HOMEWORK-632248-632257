package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzoleggero;
	private Attrezzo attrezzoPesante;
	
	@Before
	public void setUp() {
		this.borsa = new Borsa(10);
		this.attrezzoleggero = new Attrezzo("piuma",2);
		this.attrezzoPesante = new Attrezzo("spadone",11);
		
	}

	@Test
	public void testRemoveAttrezzo() {
		borsa.addAttrezzo(attrezzoleggero);
		Attrezzo rimosso = borsa.removeAttrezzo("piuma");
		assertEquals(attrezzoleggero,rimosso);
	}
	@Test
	public void testRemoveAttrezzo_ConpiuAttrezzi() {
		Attrezzo spada = new Attrezzo("spada",3);
		Attrezzo ascia = new Attrezzo("ascia",4);
		
		borsa.addAttrezzo(attrezzoleggero);
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(ascia);
		
		assertEquals(ascia, borsa.removeAttrezzo("ascia"));
		assertFalse(borsa.hasAttrezzo("ascia"));
		
	}
	@Test
	public void testRemoveAttrezzo_EffettivamenteRimosso() {
	    this.borsa.addAttrezzo(new Attrezzo("spada", 3));
	    this.borsa.addAttrezzo(new Attrezzo("ascia", 4));
	    
	    this.borsa.removeAttrezzo("ascia");
	    assertFalse(this.borsa.hasAttrezzo("ascia"));
	}
	
	@Test
	public void testRimuovoDaUnaBorsaVuota() {
		assertNull(borsa.removeAttrezzo("spada"));
	}
		
	@Test
	public void testRemoveAttrezzo_RitornaOggettoCorretto() {
		this.borsa.addAttrezzo(new Attrezzo("spada", 3));
		this.borsa.addAttrezzo(new Attrezzo("ascia", 4));
		    
		Attrezzo rimosso = this.borsa.removeAttrezzo("ascia");
		assertEquals("ascia", rimosso.getNome());
		}
		
	@Test
    public void testAddAttrezzoTroppoPesante() {
        assertFalse(this.borsa.addAttrezzo(attrezzoPesante));
    }
	@Test
	public void testTroppiAttrezziBorsaPiena() {
		for(int i=0; i<10 ; i++) {
			this.borsa.addAttrezzo(new Attrezzo("Attrezzo"+i,1));
		}
		assertFalse(this.borsa.addAttrezzo(new Attrezzo("Undicesimo",1)));
	}

}
