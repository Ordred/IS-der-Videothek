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


	public Kunde_Erfassen(UC_Kunde_erfassen uke) {

		super("Kunde erfassen");



		this.uke = uke;
		
		ok = new buttons("Ok");

		a = new ActionHandler();
		
		ok.addActionListener(a);

		gl1 = new GridLayout(8,2);
		fl = new FlowLayout();

		form = new erfassPanel(gl1);
		buttons = new erfassPanel(fl);

		speichern = new buttons("Speichern");
		abbrechen = new buttons("Abbrechen");


		name = new JTextField("Name");
		vorname = new JTextField("Vorname");
		geburtsdatum = new JTextField("Geburtsdatum");
		lieblingsgenre = new JTextField("Lieblingsgenre");
		guthaben = new JTextField("Guthaben");
		adresse = new JTextField("Adresse");
		ort = new JTextField("Ort");
		telefon = new JTextField("Telefon");

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
		form.add(guthabenL);
		form.add(guthaben);

		buttons.add(abbrechen, BorderLayout.WEST);
		buttons.add(speichern, BorderLayout.EAST);

		add(form, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);

	}

	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == ok) {
				zahl.dispose();
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
					uke.setGuthaben(Integer.parseInt(guthaben.getText()));
					uke.speichern();
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
