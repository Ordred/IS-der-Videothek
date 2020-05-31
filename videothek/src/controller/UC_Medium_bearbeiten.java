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

public class UC_Medium_bearbeiten {
	
	private Medium m;
	private Medienliste ml;
	private Film_suchen fs;
	private Filmliste fl;
	private Film f;
	private Medium_erfassen me;
	private Kundenliste kl;
	
	public UC_Medium_bearbeiten(Medium m, Medienliste ml, Filmliste fl, Kundenliste kl) {
		this.m = m;
		this.ml = ml;
		this.fl = fl;
		this.kl = kl;
		
		
		for (int i = 0; i < ml.getMedienliste().size(); i++) {
			if (ml.getMedienliste().get(i).getId() == m.getId()) {
				m = ml.getMedienliste().get(i);
			}
		}
		
		me = new Medium_erfassen(this, null, ml);
		me.setVisible(true);
		me.setSize(400, 220);
		me.setLocationRelativeTo(null);
		me.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	
	
	public Film_suchen getFs() {
		return fs;
	}


	public void setFs(Film_suchen fs) {
		this.fs = fs;
	}


	public Medium_erfassen getMe() {
		return me;
	}


	public void setMe(Medium_erfassen me) {
		this.me = me;
	}


	public void setID(int id) {
		m.setId(id);
	}
	
	public void setPreis(int preis) {
		m.setPreis(-preis);
	}
	
	
	public void setFilm2(Film f) {
		m.setFilm(f);
		
	}
	
	public void setMedium(String medium) {
		m.setMedium(medium);
	}
	
	public void speichern() {
		
		
		ml.speichern();
		
	}
	
	public void löschen() {
	
		for (int i = 0; i < ml.getMedienliste().size(); i++) {
			if (ml.getMedienliste().get(i).getId() == m.getId()) {
				ml.getMedienliste().remove(i);
				speichern();
			}
		}
		
		for (int j = 0; j < kl.getKundenliste().size(); j++) {
			for (int j2 = 0; j2 < kl.getKundenliste().get(j).getAusleihliste().size(); j2++) {
				if (kl.getKundenliste().get(j).getAusleihliste().get(j2).getId() == m.getId()) {
					kl.getKundenliste().get(j).getAusleihliste().remove(j2);
					kl.speichern();
				}
			}
			
		}
		
	}

}
