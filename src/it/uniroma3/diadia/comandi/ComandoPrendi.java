package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	private final static String NOME = "prendi";
	
	public ComandoPrendi(String attrezzo) {
		this.nomeAttrezzo = attrezzo;
	}
	
	public ComandoPrendi() {
	}

	@Override
	public void esegui(Partita partita) {
		Stanza s = partita.getStanzaCorrente();
		
		boolean trovato = s.hasAttrezzo(nomeAttrezzo);
		
		Attrezzo tool = s.getAttrezzo(nomeAttrezzo);
		
		if(trovato == true) {
			s.removeAttrezzo(tool);
		
			partita.getGiocatore().getBorsa().addAttrezzo(tool);
			
			System.out.println("Preso!");
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
