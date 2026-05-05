package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita, IO io) {
		
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		
		if(a!=null) {
			boolean preso = partita.getGiocatore().getBorsa().addAttrezzo(a);
			
			if(preso) {
				partita.getStanzaCorrente().removeAttrezzo(a);
				io.mostraMessaggio("Hai aggiunto " + nomeAttrezzo + " alla tua borsa");
				
			}else
			{
				io.mostraMessaggio("Borsa piena");
			}
		}else
		{
			io.mostraMessaggio("L'attrezzo " + nomeAttrezzo + " non è in questa stanza");
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
