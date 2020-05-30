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

	public UC_Kunde_erfassen (Kundenliste kl, String titel, Kunde k) {

		this.k = k;

		ke = new Kunde_Erfassen(this, titel, k);
		ke.setVisible(true);
		ke.setSize(400, 400);
		ke.setLocationRelativeTo(null);
		ke.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.kl = kl;
	}

	public void löschen(int id) {

		for (int i = 0; i < kl.getKundenliste().size(); i++) {
			if (kl.getKundenliste().get(i).getId().equalsIgnoreCase(Integer.toString(id))) {
				kl.getKundenliste().remove(i);
				kl.speichern();
			}
		}

	}

	public void setAdresse(String adresse) {
		System.out.println(adresse);
		System.out.println(k);
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

	public void speichern(boolean bearbeiten) {
		

		if (!bearbeiten) {
			
			k.setId(kl.getKundenliste().size());
			
			for (int i = 0; i < kl.getKundenliste().size(); i++) {
				try {
				if (!kl.getKundenliste().get(i).getId().equalsIgnoreCase(Integer.toString(i))) {
					k.setId(i);
					
					break;
				}
				} catch (NullPointerException e) {
					k.setId(i);
					
					break;
				}
			}
		}
		else {
			for (int i = 0; i < kl.getKundenliste().size(); i++) {
				System.out.println(k.getId());
				if (kl.getKundenliste().get(i).getId().equalsIgnoreCase(k.getId())) {
					kl.getKundenliste().remove(i);
					
				}
			}
		}
		System.out.println(k.getId());
		kl.kundeHinzufügen(k);
	}
}
