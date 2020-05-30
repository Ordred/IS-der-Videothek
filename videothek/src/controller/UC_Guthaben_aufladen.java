package controller;

import javax.swing.JFrame;

import gui.Guthaben_aufladen;
import gui.Kunde_anzeigen;
import model.Geschäftseinnahmen;
import model.Kunde;
import model.Kundenliste;

public class UC_Guthaben_aufladen {
	
	private Kunde k;
	private Kundenliste kl;
	private Guthaben_aufladen ga;
	
	private Kunde_anzeigen ka;
	
	private Geschäftseinnahmen ge;
	
	
	public UC_Guthaben_aufladen(Geschäftseinnahmen ge, Kunde k, Kundenliste kl, Kunde_anzeigen ka) {
		
		this.k = k;
		this.kl = kl;
		this.ka = ka;
		this.ge = ge;
		
		ga = new Guthaben_aufladen(this);
		ga.setVisible(true);
		ga.setSize(300, 150);
		ga.setLocationRelativeTo(null);
		ga.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	
	public Guthaben_aufladen getGa() {
		return ga;
	}


	public void setGa(Guthaben_aufladen ga) {
		this.ga = ga;
	}


	public void aufladen(int betrag) {
		
		ge.setGesamteinnahmen(betrag);
		ge.setJahreseinnahmen(betrag);
		ge.setMonatseinnahmen(betrag);
		ge.setWocheneinnahmen(betrag);
		ge.speichern();
		
		k.setGuthaben(betrag);
		kl.kundeBearbeiten(k);
		
		ka.repaint();
		
		
	}

}
