package controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JDialog;

import model.Film;
import model.Kunde;
import model.Kundenliste;
import model.Medienliste;
import model.Medium;

public class UC_Medium_ausleihen {

	private String medium;
	private LocalDate heute;
	private Kunde k;
	private Film f;


	private Medienliste ml;
	private Kundenliste kl;

	private Medium m;


	public UC_Medium_ausleihen(String medium, Kunde k, Film f, Medienliste ml, Kundenliste kl, Medium m) {

		this.f = f;
		this.medium = medium;
		this.k = k;
		this.ml = ml;
		this.kl = kl;
		this.m = m;

		heute = LocalDate.now();



	}


	public Kundenliste getKl() {
		return kl;
	}


	public void setKl(Kundenliste kl) {
		this.kl = kl;
	}


	public void ausleihen() {

		for (int i = 0; i < ml.getMedienliste().size(); i++) {



			for (int j = 0; j < kl.getKundenliste().size(); j++) {

				if (k.getId() == kl.getKundenliste().get(j).getId())
				{
					System.out.println("Geschafft klk");
					k = kl.getKundenliste().get(j);
				}
			}

			System.out.println((ml.getMedienliste().get(i).getFilm().getTitel().equalsIgnoreCase(m.getFilm().getTitel())));
			System.out.println(ml.getMedienliste().get(i).isLagernd());
			System.out.println(medium.equalsIgnoreCase(ml.getMedienliste().get(i).getMedium()));


			if (ml.getMedienliste().get(i).getFilm().getTitel().equalsIgnoreCase(m.getFilm().getTitel()) &&
					ml.getMedienliste().get(i).getFilm().getJahr() == m.getFilm().getJahr() &&
					ml.getMedienliste().get(i).isLagernd() && 
					medium.equalsIgnoreCase(ml.getMedienliste().get(i).getMedium())){
				System.out.println("geht2");

				


				k.getAusleihliste().add(m);
				k.setGuthaben(ml.getMedienliste().get(i).getPreis());
				kl.speichern();
				kl.laden();

				ml.getMedienliste().get(i).setRückgabedatum(heute.plusDays(7));
				ml.getMedienliste().get(i).setLagernd(false);
				ml.speichern();
				ml.laden();
			}

			else if (ml.getMedienliste().get(i).getFilm() == f && !ml.getMedienliste().get(i).isLagernd()) {
				JDialog nichtLager = new JDialog();
			}
		}

	}


	public Medium getM() {
		return m;
	}


	public void setM(Medium m) {
		this.m = m;
	}


	public String getMedium() {
		return medium;
	}


	public void setMedium(String medium) {
		this.medium = medium;
	}


	public LocalDate getHeute() {
		return heute;
	}


	public void setHeute(LocalDate heute) {
		this.heute = heute;
	}


	public Kunde getK() {
		return k;
	}


	public void setK(Kunde k) {
		this.k = k;
	}


	public Film getF() {
		return f;
	}


	public void setF(Film f) {
		this.f = f;
	}


	public Medienliste getMl() {
		return ml;
	}


	public void setMl(Medienliste ml) {
		this.ml = ml;
	}

}
