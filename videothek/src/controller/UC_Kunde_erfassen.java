package controller;

import javax.swing.Icon;
import javax.swing.JFrame;

import gui.Film_Erfassen;
import gui.Kunde_Erfassen;
import model.Kunde;
import model.Kundenliste;

public class UC_Kunde_erfassen {

	private Kunde k;
	private Kundenliste kl;
	private Kunde_Erfassen ke;

	public UC_Kunde_erfassen (Kundenliste kl) {
		k = new Kunde();
		ke = new Kunde_Erfassen(this);
		ke.setVisible(true);
		ke.setSize(400, 400);
		ke.setLocationRelativeTo(null);
		ke.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.kl = kl;
	}
	
	public void setAdresse(String adresse) {
		k.setAdresse(adresse);
	}
	
	public void setOrt(String ort) {
		k.setOrt(ort);
	}
	
	public Kunde_Erfassen getKe() {
		return ke;
	}

	public void setKe(Kunde_Erfassen ke) {
		this.ke = ke;
	}

	public void setTelefon(String telefon) {
		k.setTelefon(telefon);
	}
	

	public void setName(String name) {

		k.setName(name);

	}
	
	public void setVorname(String vorname) {

		k.setVorname(vorname);

	}
	
	public void setGeburtsdatum(String geburtsdatum) {

		k.setGeburtsdatum(geburtsdatum);

	}
	
	public void setLieblingsgenre(String lieblingsgenre) {

		k.setLieblingsgenre(lieblingsgenre);

	}
	
	public void setGuthaben(int guthaben) {

		k.setGuthaben(guthaben);

	}
	
	public void speichern() {
		k.setId(kl.getKundenliste().size()+1);
		
		for (int i = 0; i < kl.getKundenliste().size(); i++) {
			if (kl.getKundenliste().get(i).getId() != i) {
				k.setId(i);
			}
		}
		
		kl.kundeHinzufügen(k);
	}
}
