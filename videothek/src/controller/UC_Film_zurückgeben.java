package controller;

import javax.swing.JDialog;
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
		kl.laden();
		this.k = k;

		fz = new Film_zur�ckgeben(k, this);
		fz.setVisible(true);
		fz.setSize(800, 800);
		fz.setLocationRelativeTo(null);
		fz.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void zur�ckgeben(int i) {

		kl.laden();
		ml.laden();
		
		for (int j = 0; j < ml.getMedienliste().size(); j++) {
			if (ml.getMedienliste().get(j) == k.getAusleihliste().get(i)) {
				ml.getMedienliste().get(j).setLagernd(true);
				ml.speichern();
				ml.laden();
			}
		}	


		for (int j = 0; j < kl.getKundenliste().size(); j++) {
			if (kl.getKundenliste().get(j).getName().equalsIgnoreCase(k.getName()) && 
					kl.getKundenliste().get(j).getVorname().equalsIgnoreCase(k.getVorname()) && 
					kl.getKundenliste().get(j).getGeburtsdatum().equalsIgnoreCase(k.getGeburtsdatum())) 
			{
				System.out.println("Geschafft");
				k = kl.getKundenliste().get(j);
				k.getAusleihliste().remove(i);
				kl.speichern();
				kl.laden();
			}
		}

			

		
		System.out.println("Medium weg");
		
	}
}

