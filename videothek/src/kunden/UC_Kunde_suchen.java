package kunden;

import java.util.ArrayList;

import javax.swing.JFrame;

import gui.Kunde_suchen;

public class UC_Kunde_suchen {

	Kundenliste kl;

	Kunde_suchen ks;

	ArrayList<Kunde> suchergebnisse;



	public UC_Kunde_suchen(Kundenliste kl) {

		this.kl = kl;

		suchergebnisse = new ArrayList<Kunde>();

		ks = new Kunde_suchen(this, kl);

		ks.setVisible(true);
		ks.setSize(300, 150);
		ks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public ArrayList<Kunde> name(String name) {

		for (int i = 0; i < kl.getKundenliste().size(); i++) {

			if (kl.getKundenliste().get(i).getName().contains(name)) {
				suchergebnisse.add(kl.getKundenliste().get(i));
				System.out.println(kl.getKundenliste().get(i).getName());
			}
		}
		return suchergebnisse;

	}

	public ArrayList<Kunde> geburtsdatum(String geburtsdatum) {

		for (int i = 0; i < kl.getKundenliste().size(); i++) {

			if (kl.getKundenliste().get(i).getGeburtsdatum().contains(geburtsdatum)) {
				suchergebnisse.add(kl.getKundenliste().get(i));
			}
		}	
		return suchergebnisse;

	}

	public ArrayList<Kunde> vorname(String vorname) {

		for (int i = 0; i < kl.getKundenliste().size(); i++) {

			if (kl.getKundenliste().get(i).getVorname().contains(vorname)) {
				suchergebnisse.add(kl.getKundenliste().get(i));
			}
		}	
		return suchergebnisse;

	}

	public ArrayList<Kunde> lieblingsgenre(String lieblingsgenre) {

		for (int i = 0; i < kl.getKundenliste().size(); i++) {

			if (kl.getKundenliste().get(i).getLieblingsgenre().contains(lieblingsgenre)) {
				suchergebnisse.add(kl.getKundenliste().get(i));
			}
		}	
		return suchergebnisse;

	}

}
