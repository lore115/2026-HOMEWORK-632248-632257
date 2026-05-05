package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda"};

	@Override
	public void esegui(Partita partita, IO io) {
		String msg = "Comandi Disponibili:  ";
		for(int i=0; i< elencoComandi.length; i++) {
			msg += elencoComandi[i] + " ";
		}
		io.mostraMessaggio(msg);
		
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return "aiuto";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
