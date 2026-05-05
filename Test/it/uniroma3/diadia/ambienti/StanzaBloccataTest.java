package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
    
    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaAdiacente;
    private Attrezzo piedeDiPorco;
    private Attrezzo spada;
    
    @Before
    public void setUp() {
        stanzaBloccata = new StanzaBloccata("Atrio", "nord", "piedediporco");
        stanzaAdiacente = new Stanza("Biblioteca");
        piedeDiPorco = new Attrezzo("piedediporco", 2);
        spada = new Attrezzo("spada", 5);
        
        stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
    }
    
    @Test
    public void testGetStanzaAdiacente_DirezioneBloccataSenzaAttrezzo() {
        Stanza risultato = stanzaBloccata.getStanzaAdiacente("nord");
        assertSame(stanzaBloccata, risultato);
    }
    
    @Test
    public void testGetStanzaAdiacente_DirezioneBloccataConAttrezzo() {
        stanzaBloccata.addAttrezzo(piedeDiPorco);
        Stanza risultato = stanzaBloccata.getStanzaAdiacente("nord");
        assertSame(stanzaAdiacente, risultato);
    }
    
    @Test
    public void testGetStanzaAdiacente_DirezioneNonBloccataSenzaAttrezzo() {
        Stanza stanzaEst = new Stanza("Cortile");
        stanzaBloccata.impostaStanzaAdiacente("est", stanzaEst);
        
        Stanza risultato = stanzaBloccata.getStanzaAdiacente("est");
        assertSame(stanzaEst, risultato);
    }
    
    @Test
    public void testGetStanzaAdiacente_DirezioneBloccataConAttrezzoSbagliato() {
        stanzaBloccata.addAttrezzo(spada);
        Stanza risultato = stanzaBloccata.getStanzaAdiacente("nord");
        assertSame(stanzaBloccata, risultato);
    }
    
    @Test
    public void testGetDescrizione_QuandoBloccata() {
        String descrizione = stanzaBloccata.getDescrizione();
        assertTrue(descrizione.contains("nord"));
        assertTrue(descrizione.contains("piedediporco"));
    }
    
    @Test
    public void testGetDescrizione_QuandoSbloccata() {
        stanzaBloccata.addAttrezzo(piedeDiPorco);
        String descrizione = stanzaBloccata.getDescrizione();
        assertTrue(descrizione.contains("Atrio"));
    }
    
    @Test
    public void testComportamentoConLabirintoBilocale() {
        assertSame(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
        
        stanzaBloccata.addAttrezzo(piedeDiPorco);
        assertSame(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("nord"));
    }
}
