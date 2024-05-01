package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	private final static String NOME = "fine";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		System.out.println(MESSAGGIO_FINE);
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
