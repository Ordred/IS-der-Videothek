package model;

import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Film implements Serializable {
	
	private String titel;
	private int jahr;
	private String hülle;
	private String beschreibung;
	private String genre;
	private int id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHülle() {
		return hülle;
	}
	public void setHülle(String hülle) {
		this.hülle = hülle;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public int getJahr() {
		return jahr;
	}
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	

}
