package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza{
	private String attrezzoLuminoso;
	
	
	public StanzaBuia(String nome, String attrezzoLuminoso) {
		super(nome);
		this.attrezzoLuminoso = attrezzoLuminoso;
	}
	@Override
	public String getDescrizione() {
		String str = "qui c'è un buio pesto ";
		
		if(this.hasAttrezzo(this.attrezzoLuminoso)) {
			return super.getDescrizione();
		}
		else
		{
			return str;
		}
	}
}
