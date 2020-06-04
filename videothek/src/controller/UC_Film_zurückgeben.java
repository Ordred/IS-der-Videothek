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

	public Film_zur�ckgeben getFz() {
		return fz;
	}

	public void setFz(Film_zur�ckgeben fz) {
		this.fz = fz;
	}

	public void zur�ckgeben(int i) {

		
		for (int j = 0; j < ml.getMedienliste().size(); j++) {
			if (ml.getMedienliste().get(j).getId().equalsIgnoreCase(k.getAusleihliste().get(i).getId())) {
				ml.getMedienliste().get(j).setLagernd(true);
				ml.getMedienliste().get(j).setR�ckgabedatum(null);
				ml.speichern();
				ml.laden();
			}
		}	


		for (int j = 0; j < kl.getKundenliste().size(); j++) {
			if (kl.getKundenliste().get(j).getId().equalsIgnoreCase(k.getId())) 
			{
				System.out.println("Geschafft");
				try {
				kl.getKundenliste().get(j).getAusleihliste().remove(i);
				} catch (IndexOutOfBoundsException e) {
				
				}
				kl.speichern();
				kl.laden();
				k = kl.getKundenliste().get(j);
			}
		}

			

		
		System.out.println("Medium weg");
		
	}
}

