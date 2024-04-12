package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe modella il giocatore del gioco.
 *
 * @author  Daniela Nardone
 * @see Partita
 * @see Borsa
 * @version 1
 */

public class Giocatore {
	
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu = 0;
		this.borsa = new Borsa();
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
}
