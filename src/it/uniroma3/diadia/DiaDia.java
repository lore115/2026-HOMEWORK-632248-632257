package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissaa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia(IOConsole io) {
		this.io = io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		this.io.mostraMessaggio("La tua Avventura inizia In: " + this.partita.getLabirinto().getStanzaIniziale().getDescrizione());
		do
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione) && !this.partita.isFinita());
		
		if(this.partita.getGiocatore().getCfu()<=0) {
		this.io.mostraMessaggio("GAME OVER: hai finito i cfu!!");
		}
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			this.io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		String msg = "Comandi Disponibili:  ";
		for(int i=0; i< elencoComandi.length; i++) {
			msg += elencoComandi[i] + " ";
		}
		this.io.mostraMessaggio(msg);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu - 1);
			this.io.mostraMessaggio("Cfu Rimanenti: "+this.partita.getGiocatore().getCfu());
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	public void prendi(String nomeAttrezzo) {
		Attrezzo a = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		
		if(a!=null) {
			boolean preso = this.partita.getGiocatore().getBorsa().addAttrezzo(a);
			
			if(preso) {
				this.partita.getStanzaCorrente().removeAttrezzo(a);
				this.io.mostraMessaggio("Hai aggiunto " + nomeAttrezzo + " alla tua borsa");
				
			}else
			{
				this.io.mostraMessaggio("Borsa troppo piena");
			}
		}else
		{
			this.io.mostraMessaggio("L'attrezzo " + nomeAttrezzo + " non è in questa stanza");
		}
		
	}
	public void posa(String nomeAttrezzo) {
		Attrezzo a = this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		
		if(a!=null) {
			boolean posato = this.partita.getStanzaCorrente().addAttrezzo(a);
			
			if(posato) {
				this.io.mostraMessaggio("Hai posato l'attrezzo " + nomeAttrezzo);
			}
		}else
		{
			this.io.mostraMessaggio("Nella borsa non hai l'attrezzo "+ nomeAttrezzo);
		}
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}