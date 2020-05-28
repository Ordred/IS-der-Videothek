package controller;

import javax.swing.Icon;
import javax.swing.JFrame;

import gui.Film_Bearbeiten;
import model.Film;
import model.Filmliste;

public class UC_Film_bearbeiten {

	private Filmliste fl;
	private Film f;
	private Film_Bearbeiten fb;
	private UC_Film_suchen ucfs;

	public UC_Film_bearbeiten(Filmliste fl) {
		this.fl = fl;
		ucfs = new UC_Film_suchen(this, true, fl, true, null, null, null);
		
		
	}

	public void setFilm(Film f) {
		
		this.f = f;
		fb = new Film_Bearbeiten(this);
		fb.setVisible(true);
		fb.setSize(400, 430);
		fb.setLocationRelativeTo(null);
		fb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	

	public void setJahr(int jahr) {

		f.setJahr(jahr);

	}

	public void setHülle(String hülle) {
		f.setHülle(hülle);
	}
	
	public void setGenre(String genre) {

		f.setGenre(genre);

	}
	public void setTitel(String titel) {

		f.setTitel(titel);

	}
	public void setBeschreibung(String beschreibung) {

		f.setBeschreibung(beschreibung);

	}

	public void speichern() {
		for (int i = 0; i < fl.getFilmliste().size(); i++) {
			if (fl.getFilmliste().get(i) == f) {
				fl.filmÄndern(f,i);
			}
		}
	}

		public void löschen() {
			for (int i = 0; i < fl.getFilmliste().size(); i++) {
				if (fl.getFilmliste().get(i) == f) {
					fl.getFilmliste().remove(i);
					fl.speichern();
				}
			}
		}

	}
