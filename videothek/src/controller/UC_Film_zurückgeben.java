package controller;

import javax.swing.JFrame;

import gui.Film_zur�ckgeben;
import model.Kunde;
import model.Kundenliste;
import model.Medienliste;
import model.Medium;

public class UC_Film_zur�ckgeben {

	private Medienliste ml;
	private Kundenliste kl;
	private Kunde k;
	
	private Film_zur�ckgeben fz;
	
	public UC_Film_zur�ckgeben(Medienliste ml, Kundenliste kl, Kunde k) {

		this.ml = ml;
		this.kl = kl;
		this.k = k;
		
		fz = new Film_zur�ckgeben(k, this);
		fz.setVisible(true);
		fz.setSize(800, 800);
		fz.setLocationRelativeTo(null);
		fz.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void zur�ckgeben(int i) {
		
		for (int j = 0; j < ml.getMedienliste().size(); j++) {
			if (k.getAusleihliste().get(i) == ml.getMedienliste().get(j)) {
				ml.getMedienliste().get(j).setLagernd(true);
				ml.getMedienliste().get(j);
			}
		}
		k.getAusleihliste().remove(i);
		for (int j = 0; j < kl.getKundenliste().size(); j++) {
			if (k == kl.getKundenliste().get(j)) {
				kl.getKundenliste().remove(j);
				kl.getKundenliste().add(j, k);
				kl.speichern();
			}
		}
		
		
		
	}

}
