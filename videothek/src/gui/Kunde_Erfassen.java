package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.SwingConstants;


import controller.UC_Kunde_erfassen;
import model.Kunde;

public class Kunde_Erfassen extends erfassFrame{

	private UC_Kunde_erfassen uke;

	private JTextField name;
	private JTextField vorname;
	private JTextField geburtsdatum;
	private JTextField lieblingsgenre;
	private JTextField guthaben;
	private JTextField adresse;
	private JTextField ort;
	private JTextField telefon;

	private erfassLabel nameL;
	private erfassLabel vornameL;
	private erfassLabel geburtsdatumL;
	private erfassLabel lieblingsgenreL;
	private erfassLabel guthabenL;
	private erfassLabel adresseL;
	private erfassLabel ortL;
	private erfassLabel telefonL;

	private erfassPanel buttons;
	private erfassPanel form;

	private GridLayout gl1;


	private FlowLayout fl;

	private buttons speichern;
	private buttons abbrechen;

	private ActionHandler a;
	
	private JDialog zahl;
	
	private buttons ok;


	private buttons löschen;
	private JDialog löschen2;
	
	private buttons ja;
	private buttons nein;
	
	private Kunde k;

	public Kunde_Erfassen(UC_Kunde_erfassen uke, String titel, Kunde k) {

		super(titel);		
		
		this.uke = uke;
		
		this.k = k;
	
		
		löschen = new buttons("Löschen");
		
		
		ok = new buttons("Ok");
		ja = new buttons("Ja");
		nein = new buttons("Nein");

		a = new ActionHandler();
		
		ok.addActionListener(a);
		
		löschen.addActionListener(a);

		gl1 = new GridLayout(8,2);
		fl = new FlowLayout();

		form = new erfassPanel(gl1);
		buttons = new erfassPanel(fl);

		speichern = new buttons("Speichern");
		abbrechen = new buttons("Abbrechen");


		if (k.getName() == null) {
		name = new JTextField("Name");
		vorname = new JTextField("Vorname");
		geburtsdatum = new JTextField("Geburtsdatum");
		lieblingsgenre = new JTextField("Lieblingsgenre");
		guthaben = new JTextField("Guthaben");
		adresse = new JTextField("Adresse");
		ort = new JTextField("Ort");
		telefon = new JTextField("Telefon");
		}
		else {
			name = new JTextField(k.getName());
			vorname = new JTextField(k.getVorname());
			geburtsdatum = new JTextField(k.getGeburtsdatum());
			lieblingsgenre = new JTextField(k.getLieblingsgenre());
			guthaben = new JTextField(k.getGuthaben());
			adresse = new JTextField(k.getAdresse());
			ort = new JTextField(k.getOrt());
			telefon = new JTextField(k.getTelefon());
		}

		nameL = new erfassLabel("Name", SwingConstants.CENTER);
		vornameL = new erfassLabel("Vorname", SwingConstants.CENTER);
		geburtsdatumL = new erfassLabel("Geburtsdatum", SwingConstants.CENTER);
		lieblingsgenreL = new erfassLabel("Lieblingsgenre", SwingConstants.CENTER);
		guthabenL = new erfassLabel("Guthaben", SwingConstants.CENTER);
		adresseL = new erfassLabel("Adresse", SwingConstants.CENTER);
		ortL = new erfassLabel("Ort", SwingConstants.CENTER);
		telefonL = new erfassLabel("Telefon", SwingConstants.CENTER);

		name.addActionListener(a);
		vorname.addActionListener(a);
		geburtsdatum.addActionListener(a);
		lieblingsgenre.addActionListener(a);
		guthaben.addActionListener(a);

		speichern.addActionListener(a);
		abbrechen.addActionListener(a);
		
		ja.addActionListener(a);
		nein.addActionListener(a);

		form.add(nameL);
		form.add(name);
		form.add(vornameL);
		form.add(vorname);
		form.add(geburtsdatumL);
		form.add(geburtsdatum);
		form.add(lieblingsgenreL);
		form.add(lieblingsgenre);
		form.add(adresseL);
		form.add(adresse);
		form.add(ortL);
		form.add(ort);
		form.add(telefonL);
		form.add(telefon);
		if (k.getId() == null) {
		form.add(guthabenL);
		form.add(guthaben);
		}
		
		buttons.add(abbrechen, BorderLayout.WEST);
		buttons.add(speichern, BorderLayout.EAST);
		
		if (k.getName() != null) {
			buttons.add(löschen, BorderLayout.CENTER);
		}

		add(form, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);

	}

	public erfassPanel getButtons() {
		return buttons;
	}

	public void setButtons(erfassPanel buttons) {
		this.buttons = buttons;
	}

	

	public void setName(JTextField name) {
		this.name = name;
	}

	public JTextField getVorname() {
		return vorname;
	}

	public void setVorname(JTextField vorname) {
		this.vorname = vorname;
	}

	public JTextField getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(JTextField geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public JTextField getLieblingsgenre() {
		return lieblingsgenre;
	}

	public void setLieblingsgenre(JTextField lieblingsgenre) {
		this.lieblingsgenre = lieblingsgenre;
	}

	public JTextField getGuthaben() {
		return guthaben;
	}

	public void setGuthaben(JTextField guthaben) {
		this.guthaben = guthaben;
	}

	public JTextField getAdresse() {
		return adresse;
	}

	public void setAdresse(JTextField adresse) {
		this.adresse = adresse;
	}

	public JTextField getOrt() {
		return ort;
	}

	public void setOrt(JTextField ort) {
		this.ort = ort;
	}

	public JTextField getTelefon() {
		return telefon;
	}

	public void setTelefon(JTextField telefon) {
		this.telefon = telefon;
	}

	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == ok) {
				zahl.dispose();
			}
			
			if (e.getSource() == ja) {
				uke.löschen(Integer.parseInt(k.getId()));
			}
			
			if (e.getSource() == nein) {
				löschen2.dispose();
			}
			
			if (e.getSource() == löschen) {
				erfassPanel ll = new erfassPanel(new FlowLayout());
				löschen2 = new JDialog();
				löschen2.setTitle("Film löschen");
				löschen2.setSize(300, 150);
				löschen2.setLocationRelativeTo(null);
				löschen2.add(new erfassLabel("Sind Sie sicher, dass Sie diesen Kunden löschen möchten?", SwingConstants.CENTER));
				ll.add(ja);
				ll.add(nein);
				löschen2.add(ll, BorderLayout.CENTER);
				löschen2.setVisible(true);
				
				
			}
			
			

			if (e.getSource() == abbrechen) {
				dispose();
			}

			if (e.getSource() == speichern) {

				try {

					uke.setAdresse(adresse.getText());
					uke.setOrt(ort.getText());
					uke.setTelefon(telefon.getText());
					uke.setName(name.getText());
					uke.setVorname(vorname.getText());
					uke.setGeburtsdatum(geburtsdatum.getText());
					uke.setLieblingsgenre(lieblingsgenre.getText());
					if (k.getId() == null) {
					uke.setGuthaben(Integer.parseInt(guthaben.getText()));
					}
					uke.speichern(k.getId() != null);
					dispose();

				} catch (NumberFormatException exception) {
					zahl = new JDialog();
					zahl.setTitle("Bitte Zahl bei Guthaben eingeben");
					zahl.setVisible(true);
					zahl.add(new erfassLabel("Bitte Zahl bei Guthaben eingeben!", SwingConstants.CENTER), BorderLayout.CENTER);
					zahl.add(ok, BorderLayout.SOUTH);
					zahl.setSize(300, 150);
					zahl.setLocationRelativeTo(null);
					zahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} 
			}

		}

	}

}
