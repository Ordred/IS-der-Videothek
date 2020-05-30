package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import gui.Hauptmenu_Besitzer;
import gui.Kunde_suchen;
import model.Geschäftseinnahmen;
import model.Kunde;
import model.Kundenliste;

public class UC_Kunde_suchen {

	private Kundenliste kl;

	private Kunde_suchen ks;

	private ArrayList<Kunde> suchergebnisse;
	
	private Hauptmenu_Besitzer hb;

	private Geschäftseinnahmen ge;



	public UC_Kunde_suchen(Geschäftseinnahmen ge, Kundenliste kl, boolean admin) {

		this.kl = kl;
		this.ge = ge;
		
		suchergebnisse = new ArrayList<Kunde>();

		ks = new Kunde_suchen(ge, this, kl, admin);

		ks.setVisible(true);
		ks.setSize(300,200);
		ks.setLocationRelativeTo(null);
		ks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public Kundenliste getKl() {
		return kl;
	}


	public void setKl(Kundenliste kl) {
		this.kl = kl;
	}


	public ArrayList<Kunde> getSuchergebnisse() {
		return suchergebnisse;
	}


	public void setSuchergebnisse(ArrayList<Kunde> suchergebnisse) {
		this.suchergebnisse = suchergebnisse;
	}


	public Hauptmenu_Besitzer getHb() {
		return hb;
	}


	public void setHb(Hauptmenu_Besitzer hb) {
		this.hb = hb;
	}


	public Kunde_suchen getKs() {
		return ks;
	}


	public void setKs(Kunde_suchen ks) {
		this.ks = ks;
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
	
	public ArrayList<Kunde> adresse(String adresse) {

		for (int i = 0; i < kl.getKundenliste().size(); i++) {

			if (kl.getKundenliste().get(i).getName().contains(adresse)) {
				suchergebnisse.add(kl.getKundenliste().get(i));
				System.out.println(kl.getKundenliste().get(i).getName());
			}
		}
		return suchergebnisse;

	}
	
	public ArrayList<Kunde> telefo(String telefon) {

		for (int i = 0; i < kl.getKundenliste().size(); i++) {

			if (kl.getKundenliste().get(i).getName().contains(telefon)) {
				suchergebnisse.add(kl.getKundenliste().get(i));
				System.out.println(kl.getKundenliste().get(i).getName());
			}
		}
		return suchergebnisse;

	}
	
	public ArrayList<Kunde> ort(String ort) {

		for (int i = 0; i < kl.getKundenliste().size(); i++) {

			if (kl.getKundenliste().get(i).getName().contains(ort)) {
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
