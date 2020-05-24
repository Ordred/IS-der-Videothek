package kunden;

import javax.swing.JFrame;

import gui.Guthaben_aufladen;
import gui.Kunde_anzeigen;

public class UC_Guthaben_aufladen {
	
	Kunde k;
	Kundenliste kl;
	Guthaben_aufladen ga;
	
	Kunde_anzeigen ka;
	
	
	public UC_Guthaben_aufladen(Kunde k, Kundenliste kl, Kunde_anzeigen ka) {
		
		this.k = k;
		this.kl = kl;
		this.ka = ka;
		
		ga = new Guthaben_aufladen(this);
		ga.setVisible(true);
		ga.setSize(300, 100);
		ga.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	
	public void aufladen(int betrag) {
		
		k.setGuthaben(k.getGuthaben()+betrag);
		kl.kundeBearbeiten(k);
		
		ka.repaint();
		
		
	}

}
