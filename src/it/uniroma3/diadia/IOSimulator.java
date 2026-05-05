package it.uniroma3.diadia;

public class IOSimulator implements IO{
	
	private String[] righeDaLeggere;
	private int indiceRigheLette;
	
	private String[] messaggiProdotti;
	private int indiceMessaggiStampati;

	public IOSimulator(String[] righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.indiceRigheLette = 0;
		
		this.messaggiProdotti = new String[4000]; 
		this.indiceMessaggiStampati = 0;
	}

	@Override
	public String leggiRiga() {
		
		if (this.indiceRigheLette < this.righeDaLeggere.length) {
			String riga = this.righeDaLeggere[this.indiceRigheLette];
			this.indiceRigheLette++;
			return riga;
		}
		return null;
	}

	@Override
	public void mostraMessaggio(String messaggio) {

		if (this.indiceMessaggiStampati < this.messaggiProdotti.length) {
			this.messaggiProdotti[this.indiceMessaggiStampati] = messaggio;
			this.indiceMessaggiStampati++;
		}
	}

	public String[] getMessaggiProdotti() {
		return messaggiProdotti;
	}

	
	public boolean hasMessaggio(String frammento) {
		for (int i = 0; i < this.indiceMessaggiStampati; i++) {
			if (this.messaggiProdotti[i] != null && this.messaggiProdotti[i].contains(frammento)) {
				return true;
			}
		}
		return false;
	}

}
