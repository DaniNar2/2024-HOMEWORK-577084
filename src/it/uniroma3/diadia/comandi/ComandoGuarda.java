package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	private final static String NOME = "guarda";

	@Override
	public void esegui(Partita partita) {
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		System.out.println("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		System.out.println(partita.getGiocatore().getBorsa().toString());
	}
	
	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public String getParametro() {
		return null;
	}
	
	@Override
	public String getNome() {
		return this.NOME;
	}

}
