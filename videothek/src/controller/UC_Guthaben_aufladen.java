package controller;

import javax.swing.JFrame;

import gui.Guthaben_aufladen;
import gui.Kunde_anzeigen;
import model.Kunde;
import model.Kundenliste;

public class UC_Guthaben_aufladen {
	
	private Kunde k;
	private Kundenliste kl;
	private Guthaben_aufladen ga;
	
	private Kunde_anzeigen ka;
	
	
	public UC_Guthaben_aufladen(Kunde k, Kundenliste kl, Kunde_anzeigen ka) {
		
		this.k = k;
		this.kl = kl;
		this.ka = ka;
		
		ga = new Guthaben_aufladen(this);
		ga.setVisible(true);
		ga.setSize(300, 100);
		ga.setLocationRelativeTo(null);
		ga.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	
	public void aufladen(int betrag) {
		
		k.setGuthaben(betrag);
		kl.kundeBearbeiten(k);
		
		ka.repaint();
		
		
	}

}
