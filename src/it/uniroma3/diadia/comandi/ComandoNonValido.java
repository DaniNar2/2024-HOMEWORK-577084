package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	private final static String NOME = "non valido";
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Comando non valido");
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
