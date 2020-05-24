package kunden;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Kundenliste implements Serializable{
	
	private ArrayList<Kunde> kundenliste;
	private String datei;
	private FileOutputStream fos;
	private ObjectOutputStream out;
	private FileInputStream fis;
	private ObjectInputStream in;

	
	public Kundenliste() {
		kundenliste = new ArrayList<Kunde>();
		datei = "kundenlist.ser";		
	}
	
	public void kundeBearbeiten(Kunde k) {
		
		for (int i = 0; i < kundenliste.size(); i++) {
			if (k == kundenliste.get(i)) {
				kundenliste.set(i, k);
			}
		}
		speichern();
		
	}
	
	public void kundeHinzufügen(Kunde k) {
		kundenliste.add(k);
		speichern();

	}
	
	public void laden() {

		try {
		fis = new FileInputStream(datei);
		in = new ObjectInputStream(fis);
		
		kundenliste = (ArrayList<Kunde>)in.readObject();
		} catch (FileNotFoundException e) {
			
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
			out = new ObjectOutputStream(fos);

			out.writeObject(kundenliste);

			fos.close();
			out.close();

			System.out.println("gespeichert");

		} catch (IOException e) {
			System.out.println("io gesp k");
		}		
	}
	
	public ArrayList<Kunde> getKundenliste() {
		return kundenliste;
	}

	public void setKundenliste(ArrayList<Kunde> kundenliste) {
		this.kundenliste = kundenliste;
	}

}
