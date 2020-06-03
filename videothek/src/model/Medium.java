package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Medium implements Serializable {

	private String medium;
	private String id;
	private Film film;
	private boolean lagernd;
	private LocalDate r�ckgabedatum;
	private int preis;

	public Medium() {

		lagernd = true;
		preis = 5;

	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	public boolean isLagernd() {
		return lagernd;
	}

	public void setLagernd(boolean lagernd) {
		this.lagernd = lagernd;
	}

	public LocalDate getR�ckgabedatum() {
		return r�ckgabedatum;
	}

	public void setR�ckgabedatum(LocalDate r�ckgabedatum) {
		this.r�ckgabedatum = r�ckgabedatum;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getId() {
		return id;
	}

	public void setId(int id) {
		this.id = Integer.toString(id);
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}
