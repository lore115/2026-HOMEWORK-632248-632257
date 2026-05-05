package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String porta;
	private String chiave;
	
	public StanzaBloccata(String nome,String porta,String chiave) {
		super(nome);
		this.porta = porta;
		this.chiave = chiave;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		
		
		if(this.porta.equals(direzione) && !this.hasAttrezzo(chiave)) {
			return this;
		}
		else
		{
			return super.getStanzaAdiacente(direzione);
		}
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.chiave)) {
			return "Ti serve una chiave per aprire questa porta a : " + porta + "\n" +
					   "Oggetto mancante: " + chiave +"\n\n" + super.getDescrizione();
		}
		return super.getDescrizione();
	}
	
	
	

}
