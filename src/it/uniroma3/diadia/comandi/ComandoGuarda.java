package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		
		io.mostraMessaggio("Stato della Partita: ");
		io.mostraMessaggio("CFU rimanenti: "+partita.getGiocatore().getCfu());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}

	@Override
	public void setParametro(String parametro) {

	}

	@Override
	public String getNome() {
		return "esegui";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
