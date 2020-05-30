package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Geschäftseinnahmen {

	private String datei;
	private FileOutputStream fos;
	private ObjectOutputStream oos;

	private FileInputStream fis;
	private ObjectInputStream ois;

	private int [] einnahmen;

	private LocalDate woche;
	private LocalDate monat;
	private LocalDate jahr;

	public Geschäftseinnahmen() {
		datei = "geschäftseinnahmen.ser";

		einnahmen = new int[4];

	}

	public void laden() {

		try {
			fis = new FileInputStream(datei);
			ois = new ObjectInputStream(fis);

			einnahmen = (int[])ois.readObject();
		} catch (FileNotFoundException e) {

			speichern();
		}
		catch (IOException e) {
			System.out.println("iokunde");

		}
		catch (ClassNotFoundException e) {

		}

	}



	public void speichern() {

		try {
			fos = new FileOutputStream(datei);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(einnahmen);

			fos.close();
			oos.close();

			System.out.println("gespeichert");

		} catch (IOException e) {
			einnahmen = new int[4];
			System.out.println("io gesp k");
		}		
	}

	public void setWocheneinnahmen(int einnahme) {
		try {
			if (woche.isEqual(LocalDate.now().plusWeeks(1))) {
				woche = LocalDate.now();
				einnahmen[0] = 0;
			}
		} catch (NullPointerException e) {
			woche = LocalDate.now();
		}
		einnahmen[0] += einnahme;
	}

	public int wochenEinnahmen() {
		return einnahmen[0];
	}

	public void setMonatseinnahmen(int einnahme) {
		try {
			if (monat.isEqual(LocalDate.now().plusMonths(1))) {
				monat = LocalDate.now();
				einnahmen[1] = 0;
			}
		} catch (NullPointerException e) {
			monat = LocalDate.now();
		}
		einnahmen[1] += einnahme;
	}

	public int monatsEinnahmen() {
		return einnahmen[1];
	}

	public void setJahreseinnahmen(int einnahme) {
		try {
			if (jahr.isEqual(LocalDate.now().plusYears(1))) {
				jahr = LocalDate.now();
				einnahmen[2] = 0;
			}
		} catch (NullPointerException e) {
			jahr = LocalDate.now();
		}
		einnahmen[2] += einnahme;
	}

	public int jahresEinnahmen() {
		return einnahmen[2];
	}

	public void setGesamteinnahmen(int einnahme) {
		einnahmen[3] += einnahme;
	}

	public int gesamtEinnahmen() {
		return einnahmen[3];
	}

}
