package filme;

import java.util.ArrayList;

import javax.swing.JFrame;

import gui.Film_suchen;
import kunden.Kundenliste;

public class UC_Film_suchen {

	private Filmliste fl;

	private Film_suchen fs;
	
	private Kundenliste kl;

	private ArrayList<Film> suchergebnisse;

	private boolean medium;
	
	private Medienliste ml;


	public UC_Film_suchen(Filmliste fl, boolean medium, Kundenliste kl, Medienliste ml) {

		this.fl = fl;
		this.medium = medium;
		this.kl = kl;
		this.ml = ml;
		
		
		suchergebnisse = new ArrayList<Film>();
		
		if (!medium) {

		fs = new Film_suchen(this, medium, null,  false, null, kl, ml);

		fs.setVisible(true);
		fs.setSize(300,150);
		fs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}


	public ArrayList<Film> titel(String titel) {

		for (int i = 0; i < fl.getFilmliste().size(); i++) {

			if (fl.getFilmliste().get(i).getTitel().contains(titel)) {
				suchergebnisse.add(fl.getFilmliste().get(i));
			}
		}
		return suchergebnisse;

	}

	public ArrayList<Film> jahr(int jahr) {

		for (int i = 0; i < fl.getFilmliste().size(); i++) {

			if (fl.getFilmliste().get(i).getJahr() == jahr) {
				suchergebnisse.add(fl.getFilmliste().get(i));
			}
		}	
		return suchergebnisse;

	}

	public ArrayList<Film> beschreibung(String beschreibung) {

		for (int i = 0; i < fl.getFilmliste().size(); i++) {

			if (fl.getFilmliste().get(i).getTitel().contains(beschreibung)) {
				suchergebnisse.add(fl.getFilmliste().get(i));
			}
		}	
		return suchergebnisse;

	}

	public ArrayList<Film> genre(String genre) {

		for (int i = 0; i < fl.getFilmliste().size(); i++) {

			if (fl.getFilmliste().get(i).getTitel().contains(genre)) {
				suchergebnisse.add(fl.getFilmliste().get(i));
			}
		}	
		return suchergebnisse;

	}

}
