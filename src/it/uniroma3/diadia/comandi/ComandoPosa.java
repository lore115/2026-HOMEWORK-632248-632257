package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita, IO io) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		
		if(a!=null) {
			boolean posato = partita.getStanzaCorrente().addAttrezzo(a);
			
			if(posato)
			{
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				io.mostraMessaggio("Hai posato l'attrezzo "+ nomeAttrezzo);
				
			}else
			{
				io.mostraMessaggio("La stanza è piena di oggetti non puoi posarlo qui ");
			}
		}else
		{
			io.mostraMessaggio("Nella borsa non hai l'attrezzo"+ nomeAttrezzo);
		}
	}
	
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
