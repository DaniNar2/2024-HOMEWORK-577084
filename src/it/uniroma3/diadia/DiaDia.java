package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "posa", "prendi", "fine"};

	private Partita partita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private IOConsole gestoreIoConsole;

	public DiaDia() {
		this.labirinto = new Labirinto();
		this.partita = new Partita(this.labirinto);
		this.gestoreIoConsole = new IOConsole();
	}

	public void gioca() {
		
		String istruzione;

		this.gestoreIoConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		do	
			istruzione = this.gestoreIoConsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		if(istruzione.isBlank()) {
			return false;
		}
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		this.gestoreIoConsole.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.gestoreIoConsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.gestoreIoConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		this.gestoreIoConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	/**
	 * Comando "Prendi".
	 */
	
	private void prendi(String nomeAttrezzo) {
		
		Stanza s = this.partita.getStanzaCorrente();
		
		boolean trovato = s.hasAttrezzo(nomeAttrezzo);
		
		Attrezzo tool = s.getAttrezzo(nomeAttrezzo);
		
		if(trovato == true) {
			s.removeAttrezzo(tool);
		
			this.partita.getGiocatore().getBorsa().addAttrezzo(tool);
			
			this.gestoreIoConsole.mostraMessaggio("Preso!");
		}
		
		else {
			this.gestoreIoConsole.mostraMessaggio("Attrezzo non trovato!");
		}
	}
	
	/**
	 * Comando "Posa".
	 */
	
	private void posa(String nomeAttrezzo) {
		
		Stanza s = this.partita.getStanzaCorrente();
		
		boolean trovato = this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo);
		
		Attrezzo tool = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		
		if(trovato == true) {
			
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		
			s.addAttrezzo(tool);
			
			this.gestoreIoConsole.mostraMessaggio("Posato!");
		}
		
		else {
			this.gestoreIoConsole.mostraMessaggio("Attrezzo non trovato!");
		}
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.gestoreIoConsole.mostraMessaggio("Grazie di aver giocato!");
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia();
		gioco.gioca();
		
	}
}