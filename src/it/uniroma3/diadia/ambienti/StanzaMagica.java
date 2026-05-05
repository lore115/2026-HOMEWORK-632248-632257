package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	
	private int contatoreAttrezziPosati;
	private int SogliaMagica;
	
	public  StanzaMagica(String nome) {
		this(nome , SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.SogliaMagica = soglia;
	}
	/*
	Non è l unica soluzione difatti potremmo permettere alla classe stanza magica
	di accedere alle variabili private in quanto classe derivata stretta di Stanza
	per farlo potremmo utilzizare un nuovo tipo ovvero il protected (non è una buona soluzione)
	Questo perchè rende le due classi fortemente accoppiati che ne deriva una qualità bassa del codice
	*/
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
			if (this.contatoreAttrezziPosati>this.SogliaMagica)
				attrezzo = this.modificaAttrezzo(attrezzo);
			
	return super.addAttrezzo(attrezzo);
	}
	
	//String builder ci permette di modificare una stringa
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
			nomeInvertito = new StringBuilder(attrezzo.getNome());
			nomeInvertito = nomeInvertito.reverse();
			attrezzo = new Attrezzo(nomeInvertito.toString(),
		pesoX2);
			
		return attrezzo;
	}
	
}
