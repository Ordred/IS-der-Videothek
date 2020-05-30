package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import gui.Film_suchen;
import gui.Medium_suchen;
import model.Filmliste;
import model.Kundenliste;
import model.Medienliste;
import model.Medium;

public class UC_Medium_suchen {

	private Medienliste ml;


	private Medium_suchen ms;

	private ArrayList<Medium> suchergebnisse;
	
	private Kundenliste kl;
	
	private Filmliste fl;



	public UC_Medium_suchen(Filmliste fl, Medienliste ml, Kundenliste kl) {

		this.ml = ml;
		this.kl = kl;
		this.fl = fl;

		suchergebnisse = new ArrayList<Medium>();

		ms = new Medium_suchen( this, fl, kl, ml);

		ms.setVisible(true);
		ms.setSize(300,200);
		ms.setLocationRelativeTo(null);
		ms.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public Medium_suchen getMs() {
		return ms;
	}


	public void setMs(Medium_suchen ms) {
		this.ms = ms;
	}


	public ArrayList<Medium> getSuchergebnisse() {
		return suchergebnisse;
	}


	public void setSuchergebnisse(ArrayList<Medium> suchergebnisse) {
		this.suchergebnisse = suchergebnisse;
	}


	public ArrayList<Medium> titel(String titel) {

		for (int i = 0; i < ml.getMedienliste().size(); i++) {

			if (ml.getMedienliste().get(i).getFilm().getTitel().contains(titel)) {
				suchergebnisse.add(ml.getMedienliste().get(i));
			}
		}
		return suchergebnisse;
	}
	
	public ArrayList<Medium> jahr(int jahr) {

		for (int i = 0; i < ml.getMedienliste().size(); i++) {

			if (ml.getMedienliste().get(i).getFilm().getJahr() == jahr) {
				suchergebnisse.add(ml.getMedienliste().get(i));
			}
		}
		return suchergebnisse;

	}
	
	public ArrayList<Medium> genre(String genre) {

		for (int i = 0; i < ml.getMedienliste().size(); i++) {

			if (ml.getMedienliste().get(i).getFilm().getTitel().contains(genre)) {
				suchergebnisse.add(ml.getMedienliste().get(i));
			}
		}
		return suchergebnisse;

	}
	
	public ArrayList<Medium> id(int id) {

		for (int i = 0; i < ml.getMedienliste().size(); i++) {

			if (ml.getMedienliste().get(i).getId() == id) {
				suchergebnisse.add(ml.getMedienliste().get(i));
			}
		}
		return suchergebnisse;

	}
	
	public ArrayList<Medium> medium(String medium) {

		for (int i = 0; i < ml.getMedienliste().size(); i++) {

			if (ml.getMedienliste().get(i).getMedium().contains(medium)) {
				suchergebnisse.add(ml.getMedienliste().get(i));
			}
		}
		return suchergebnisse;

	}



}
