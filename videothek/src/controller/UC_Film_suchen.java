package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import gui.Film_suchen;
import model.Film;
import model.Filmliste;
import model.Kunde;
import model.Kundenliste;
import model.Medienliste;

public class UC_Film_suchen {

	private Filmliste fl;

	private Film_suchen fs;
	
	private Kundenliste kl;

	private ArrayList<Film> suchergebnisse;

	private boolean medium;
	
	private Medienliste ml;
	
	private Kunde k;
	private UC_Film_bearbeiten ucfb;
	private boolean fb;


	public UC_Film_suchen(UC_Film_bearbeiten ucfb, boolean fb, Filmliste fl, boolean medium, Kundenliste kl, Medienliste ml, Kunde k) {

		this.fl = fl;
		this.medium = medium;
		this.kl = kl;
		this.ml = ml;
		this.k = k;
		this.ucfb = ucfb;
		this.fb = fb;
		
		suchergebnisse = new ArrayList<Film>();
		
		if (!medium || fb) {

		fs = new Film_suchen(ucfb, this, medium, k,  k != null, null, kl, ml);

		fs.setVisible(true);
		fs.setSize(300,150);
		fs.setLocationRelativeTo(null);
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
