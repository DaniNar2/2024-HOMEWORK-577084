package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private String nomeAttrezzo;
	private final static String NOME = "posa";
	
	public ComandoPosa(String attrezzo) {
		this.nomeAttrezzo = attrezzo;
	}
	
	public ComandoPosa() {
	}

	@Override
	public void esegui(Partita partita) {
		Stanza s = partita.getStanzaCorrente();
		
		boolean trovato = partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo);
		
		Attrezzo tool = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		
		if(trovato == true) {
			
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		
			s.addAttrezzo(tool);
			
			System.out.println("Posato!");
		}
		
		else {
			System.out.println("Attrezzo non trovato!");
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
	@Override
	public String getNome() {
		return this.NOME;
	}
}
