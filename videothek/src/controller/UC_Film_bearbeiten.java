package controller;

import javax.swing.Icon;
import javax.swing.JFrame;

import gui.Film_Bearbeiten;
import model.Film;
import model.Filmliste;
import model.Kundenliste;
import model.Medienliste;

public class UC_Film_bearbeiten {

	private Filmliste fl;
	private Film f;
	private Film_Bearbeiten fb;
	private UC_Film_suchen ucfs;
	private Medienliste ml;
	private Kundenliste kl;

	public UC_Film_bearbeiten(Filmliste fl, Medienliste ml, Kundenliste kl) {
		this.fl = fl;
		this.ml = ml;
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
	

	public Film_Bearbeiten getFb() {
		return fb;
	}

	public void setFb(Film_Bearbeiten fb) {
		this.fb = fb;
	}

	public Film getF() {
		return f;
	}

	public void setF(Film f) {
		this.f = f;
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
					
					for (int j = 0; j < kl.getKundenliste().size(); j++) {
						for (int j2 = 0; j2 < kl.getKundenliste().get(j2).getAusleihliste().size(); j2++) {
							if (kl.getKundenliste().get(j).getAusleihliste().get(j2).getFilm() == f) {
								kl.getKundenliste().get(j).getAusleihliste().remove(j2);
							}
						}
						
					}
					for (int j = 0; j < ml.getMedienliste().size(); j++) {
						if (ml.getMedienliste().get(j).getFilm() == f) {
							ml.getMedienliste().remove(j);
						}
					}
					fl.getFilmliste().remove(i);
					fl.speichern();
				}
			}
		}

	}
