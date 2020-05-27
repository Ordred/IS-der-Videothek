package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Filmliste implements Serializable{

	private ArrayList<Film> filmliste;
	private String datei;
	private FileOutputStream fos;
	private ObjectOutputStream out;
	private FileInputStream fis;
	private ObjectInputStream in;


	public Filmliste() {
		filmliste = new ArrayList<Film>();
		datei = "filmliste.ser";
	}
	
	public void filmÄndern(Film f, int i) {
		filmliste.remove(i);
		filmliste.add(i, f);
		speichern();
	}


	public void filmHinzufügen(Film f) {
		filmliste.add(f);
		speichern();

	}

	public void laden() {

		try {
		fis = new FileInputStream(datei);
		in = new ObjectInputStream(fis);
		
		filmliste = (ArrayList<Film>)in.readObject();
		} catch (FileNotFoundException e) {
			
		}
		catch (IOException e) {
			System.out.println("iofilm");
			filmliste = new ArrayList<Film>();
			
		}
		catch (ClassNotFoundException e) {
			
		}
	}


	public void speichern() {

		try {
			fos = new FileOutputStream(datei);
			out = new ObjectOutputStream(fos);

			out.writeObject(filmliste);

			fos.close();
			out.close();

			System.out.println("gespeichert");

		} catch (IOException e) {

		}		
	}

	public ArrayList<Film> getFilmliste() {
		System.out.println("filmliste holen");
		System.out.println(filmliste.get(0).getTitel());
		return filmliste;
	}

	public void setFilmliste(ArrayList<Film> filmliste) {
		this.filmliste = filmliste;
	}

}
