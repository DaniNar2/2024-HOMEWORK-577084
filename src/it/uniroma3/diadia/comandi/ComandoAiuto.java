package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertNotNull;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoAiuto implements Comando{
	static final private String[] elencoComandi = {"vai", "aiuto", "posa", "prendi", "guarda", "fine"};
	private final static String NOME = "aiuto";
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
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
