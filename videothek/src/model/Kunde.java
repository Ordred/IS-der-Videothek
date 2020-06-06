package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;



public class Kunde implements Serializable {
	
	private String name;
	private String vorname;
	private String geburtsdatum;
	private String lieblingsgenre;
	private int guthaben;
	private String adresse;
	private String ort;
	private String telefon;
	private String id;
	
	public String getId() {
		return id;
	}


	public void setId(int id) {
		this.id = Integer.toString(id);
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getOrt() {
		return ort;
	}


	public void setOrt(String ort) {
		this.ort = ort;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	private ArrayList<Medium> ausleihliste;
	
	public Kunde() {
		guthaben = 0;
		
		ausleihliste = new ArrayList<Medium>();
	}
	
	
	public ArrayList<Medium> getAusleihliste() {
		return ausleihliste;
	}
	public void setAusleihliste(ArrayList<Medium> ausleihliste) {
		this.ausleihliste = ausleihliste;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public String getLieblingsgenre() {
		return lieblingsgenre;
	}
	public void setLieblingsgenre(String lieblingsgenre) {
		this.lieblingsgenre = lieblingsgenre;
	}
	public int getGuthaben() {
		return guthaben;
	}
	public void setGuthaben(int guthaben) {
		this.guthaben += guthaben;
	}
	
}
