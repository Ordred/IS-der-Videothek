package filme;

import java.util.ArrayList;

import javax.swing.JFrame;

import gui.Film_suchen;

public class UC_Film_suchen {

	Filmliste fl;

	Film_suchen fs;

	ArrayList<Film> suchergebnisse;



	public UC_Film_suchen(Filmliste fl) {

		this.fl = fl;

		suchergebnisse = new ArrayList<Film>();

		fs = new Film_suchen(this);

		fs.setVisible(true);
		fs.setSize(300,150);
		fs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
