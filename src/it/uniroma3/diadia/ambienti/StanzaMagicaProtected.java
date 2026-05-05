package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {

	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	private static final int SOGLIA_MAGICA_DEFAULT = 3;

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati > this.sogliaMagica) {
			attrezzo = this.modificaAttrezzo(attrezzo);
		}
		
		// Ora possiamo accedere a a numeroAttrezzi e attrezzi direttamente!
		// Non siamo obbligati a usare super.addAttrezzo(attrezzo)
		
		if (this.numeroAttrezzi < this.attrezzi.length) { 
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		return false;
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
		String nuovoNome = nomeInvertito.reverse().toString();
		int nuovoPeso = attrezzo.getPeso() * 2;
		return new Attrezzo(nuovoNome, nuovoPeso);
	}
}