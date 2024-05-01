package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String nome;
	private String attrezzoIlluminante;
	
	public StanzaBuia(String nome , String attrezzoLucente) {
		super(nome);
		this.attrezzoIlluminante = attrezzoLucente;
	}

	@Override
	public String getDescrizione() {
		String buio = new String();
		buio = "Qui c'è un buio pesto";
		if(!this.hasAttrezzo(attrezzoIlluminante))
			return buio;
		return super.getDescrizione();
	}
}
