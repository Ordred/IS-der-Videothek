package controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

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
	
	
	public void ausleihen() {
		
		for (int i = 0; i < ml.getMedienliste().size(); i++) {
			
			
			if (ml.getMedienliste().get(i).getFilm().getTitel().toString().contains(f.getTitel().toString()) && ml.getMedienliste().get(i).getFilm().getJahr() == f.getJahr() && ml.getMedienliste().get(i).isLagernd() && ml.getMedienliste().get(i).getMedium().equalsIgnoreCase(medium)) {
				System.out.println("geht2");
				
				if(m == null) {
				m = ml.getMedienliste().get(i);
				}
				k.getAusleihliste().add(m);
				k.setGuthaben(ml.getMedienliste().get(i).getPreis());
				
				for (int j = 0; j < kl.getKundenliste().size(); j++) {
					if (kl.getKundenliste().get(j) == k) {
						kl.getKundenliste().remove(j);
						kl.getKundenliste().add(j, k);					}
				}
				kl.speichern();
				
				
				m.setLagernd(false);
				m.setR�ckgabedatum(heute.plusDays(7));
				ml.speichern();
			}
			
			else if (ml.getMedienliste().get(i).getFilm() == f && !ml.getMedienliste().get(i).isLagernd()) {
				
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