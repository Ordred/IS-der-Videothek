package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


import controller.UC_Guthaben_aufladen;
import controller.UC_Kunde_erfassen;
import gui_elemente.Buttons;
import gui_elemente.ErfassLabel;
import gui_elemente.ErfassPanel;
import model.Geschäftseinnahmen;
import model.Kunde;
import model.Kundenliste;

public class Kunde_anzeigen extends JFrame {
	
	private Kunde k;
	private Kundenliste kl;
	
	private UC_Guthaben_aufladen uga;
	
	private ActionHandler a;
	
	private Kunde_anzeigen ka;
	
	private GridLayout gl;
	private FlowLayout fl;
	
	private ErfassPanel angaben;
	private ErfassPanel buttons;
	
	private ErfassLabel name;
	private ErfassLabel vorname;
	private ErfassLabel geburtsdatum;
	private ErfassLabel lieblingsgenre;
	private ErfassLabel guthaben;
	private ErfassLabel adresse;
	private ErfassLabel ort;
	private ErfassLabel telefon;
	
	private ErfassLabel nameT;
	private ErfassLabel vornameT;
	private ErfassLabel geburtsdatumT;
	private ErfassLabel lieblingsgenreT;
	private ErfassLabel guthabenT;
	private ErfassLabel adresseT;
	private ErfassLabel ortT;
	private ErfassLabel telefonT;
	
	private Buttons guthabenaufladen;
	private Buttons abbrechen;
	private Buttons bearbeiten;
	private UC_Kunde_erfassen uckb;
	private Geschäftseinnahmen ge;
	
	
	
	public Kunde_anzeigen(Geschäftseinnahmen ge, Kunde k, Kundenliste kl) {
		super("Kundeninformationen");
		
		this.ge = ge;
		
		a = new ActionHandler();
		
		this.k = k;
		this.kl = kl;
		ka = this;
		
		angaben = new ErfassPanel();
		buttons = new ErfassPanel();
		
		name = new ErfassLabel("Name");
		vorname = new ErfassLabel("Vorname");
		geburtsdatum = new ErfassLabel("Geburtsdatum");
		lieblingsgenre = new ErfassLabel("Lieblingsgenre");
		adresse = new ErfassLabel("Adresse");
		telefon = new ErfassLabel("Telefon");
		ort = new ErfassLabel("Ort");
		guthaben = new ErfassLabel("Guthaben");
		
		nameT = new ErfassLabel(k.getName());
		vornameT = new ErfassLabel(k.getVorname());
		geburtsdatumT = new ErfassLabel(k.getGeburtsdatum());
		lieblingsgenreT = new ErfassLabel(k.getLieblingsgenre());
		adresseT = new ErfassLabel(k.getAdresse());
		ortT = new ErfassLabel(k.getOrt());
		telefonT = new ErfassLabel(k.getTelefon());
		guthabenT = new ErfassLabel(Integer.toString(k.getGuthaben()));
		
		
		gl = new GridLayout(8, 2);
		fl = new FlowLayout();
		
		angaben.setLayout(gl);
		buttons.setLayout(fl);
		
		abbrechen = new Buttons("Abbrechen");
		guthabenaufladen = new Buttons("Guthaben aufladen");
		bearbeiten = new Buttons("Bearbeiten");
		
		abbrechen.addActionListener(a);
		guthabenaufladen.addActionListener(a);
		bearbeiten.addActionListener(a);
		
		angaben.add(name);
		angaben.add(nameT);
		angaben.add(vorname);
		angaben.add(vornameT);
		angaben.add(geburtsdatum);
		angaben.add(geburtsdatumT);
		angaben.add(lieblingsgenre);
		angaben.add(lieblingsgenreT);
		angaben.add(adresse);
		angaben.add(adresseT);
		angaben.add(ort);
		angaben.add(ortT);
		angaben.add(telefon);
		angaben.add(telefonT);
		angaben.add(guthaben);
		angaben.add(guthabenT);
		
		buttons.add(abbrechen);
		buttons.add(guthabenaufladen);
		buttons.add(bearbeiten);
		
		add(angaben, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);		
		
	}
	
	
	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == abbrechen) {
				dispose();
			}
			
			if (e.getSource() == guthabenaufladen) {
				uga = new UC_Guthaben_aufladen(ge, k, kl, ka);
				validate();
				repaint();
			}
			
			if (e.getSource() == bearbeiten) {
				uckb = new UC_Kunde_erfassen(ge, kl,"Kunde bearbeiten", k);
			}
			
			
		}
		
	}

}
