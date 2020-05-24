package filme;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Medienliste implements Serializable{

	private ArrayList<Medium> medienliste;
	private String datei;
	private FileOutputStream fos;
	private ObjectOutputStream out;
	private FileInputStream fis;
	private ObjectInputStream in;


	public Medienliste() {
		medienliste = new ArrayList<Medium>();
		datei = "medienliste.ser";
	}


	public void mediumHinzufügen(Medium m) {
		medienliste.add(m);
		speichern();

	}

	public void laden() {

		try {
		fis = new FileInputStream(datei);
		in = new ObjectInputStream(fis);
		
		medienliste = (ArrayList<Medium>)in.readObject();
		} catch (FileNotFoundException e) {
			
		}
		catch (IOException e) {
			System.out.println("iofilm");
			
		}
		catch (ClassNotFoundException e) {
			
		}
	}


	public void speichern() {

		try {
			fos = new FileOutputStream(datei);
			out = new ObjectOutputStream(fos);

			out.writeObject(medienliste);

			fos.close();
			out.close();

			System.out.println("gespeichert");

		} catch (IOException e) {

		}		
	}

	public ArrayList<Medium> getMedienliste() {

		return medienliste;
	}

	public void setFilmliste(ArrayList<Medium> medienliste) {
		this.medienliste = medienliste;
	}

}
