package controller;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JFrame;

import gui.Film_Erfassen;
import model.Film;
import model.Filmliste;

public class UC_Film_erfassen {

	private Film f;
	private Filmliste fl;
	private Film_Erfassen fe;

	public UC_Film_erfassen (Filmliste fl) {
		f = new Film();
		fe = new Film_Erfassen(this);
		fe.setVisible(true);
		fe.setSize(400, 400);
		fe.setLocationRelativeTo(null);
		fe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.fl = fl;
	}
	
	
	public Film_Erfassen getFe() {
		return fe;
	}


	public void setFe(Film_Erfassen fe) {
		this.fe = fe;
	}


	public void setHülle(String datei) {
		f.setHülle(datei);
	}
	

	public void setJahr(int jahr) {

		f.setJahr(jahr);

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
		
		if (f.getId() == null) {
		int id = 0;
		
		for (int i = 0; i < fl.getFilmliste().size(); i++) {
			if (Integer.parseInt(fl.getFilmliste().get(i).getId()) >= id)
			{
			id = Integer.parseInt(fl.getFilmliste().get(i).getId())+1;
			}
		}
		
		f.setId(id);
		}
		fl.filmHinzufügen(f);
	}
}
