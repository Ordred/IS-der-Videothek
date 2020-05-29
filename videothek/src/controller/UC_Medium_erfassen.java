package controller;

import javax.swing.JFrame;

import gui.Film_suchen;
import gui.Medium_erfassen;
import model.Film;
import model.Filmliste;
import model.Kunde;
import model.Kundenliste;
import model.Medienliste;
import model.Medium;

public class UC_Medium_erfassen {
	
	private Medium m;
	private Medienliste ml;
	private Film_suchen fs;
	private Filmliste fl;
	private Film f;
	private Medium_erfassen me;
	private Kundenliste kl;
	
	public UC_Medium_erfassen(Medienliste ml, Filmliste fl) {
		m = new Medium();
		this.ml = ml;
		this.fl = fl;
		
		me = new Medium_erfassen(this, ml);
		me.setVisible(true);
		me.setSize(350, 150);
		me.setLocationRelativeTo(null);
		me.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	
	
	public void setID(int id) {
		m.setId(id);
	}
	
	public void setPreis(int preis) {
		m.setPreis(-preis);
	}
	
	public void setFilm() {
		fs = new Film_suchen(null, new UC_Film_suchen(null, false, fl, true, kl, ml, null), true, null, true, this, kl, ml);
		fs.setVisible(true);
		fs.setSize(300, 200);
		fs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public void setFilm2(Film f) {
		m.setFilm(f);
		
	}
	
	public void setMedium(String medium) {
		m.setMedium(medium);
	}
	
	public void speichern() {
		
		
		ml.mediumHinzufügen(m);
		
	}

}
