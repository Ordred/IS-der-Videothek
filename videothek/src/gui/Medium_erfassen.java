package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.UC_Medium_bearbeiten;
import controller.UC_Medium_erfassen;
import gui_elemente.Buttons;
import gui_elemente.ErfassLabel;
import gui_elemente.ErfassPanel;
import gui_elemente.LöschDialog;
import gui_elemente.SuchFrame;
import model.Medienliste;

public class Medium_erfassen extends SuchFrame{

	private ErfassLabel mediumL;
	private JComboBox<String> medium;

	private String [] mArten = {"Blu-Ray","DVD","VHS"};
	private ErfassLabel preisL;
	private JTextField preis;

	private Buttons filmerfassen;

	private Buttons speichern;
	private Buttons abbrechen;
	private Buttons löschen;
	private Buttons bearbeiten;

	private ErfassPanel buttons;
	private ErfassPanel preise;
	private ErfassPanel medien;

	private ActionHandler a;

	private UC_Medium_erfassen ume;
	private UC_Medium_bearbeiten umb;
	private Medienliste ml;

	private Buttons ja;
	private Buttons nein;
	private LöschDialog löschen2;
	
	private JDialog zahl;
	private Buttons ok;


	public Medium_erfassen(UC_Medium_bearbeiten umb, UC_Medium_erfassen ume, Medienliste ml) {
		super("Medium erfassen");

		setLocationRelativeTo(null);

		this.ume = ume;		
		this.ml = ml;
		this.umb = umb;	


		a = new ActionHandler();
		
		zahl = new JDialog();
		ok = new Buttons("Ok");
		ok.addActionListener(a);
		
		buttons = new ErfassPanel(new FlowLayout());
		medien = new ErfassPanel(new FlowLayout());
		preise = new ErfassPanel(new FlowLayout());	



		mediumL = new ErfassLabel("Medium", SwingConstants.LEFT);
		medium = new JComboBox<String>(mArten);

		preisL = new ErfassLabel("Preis", SwingConstants.LEFT);
		preis = new JTextField("Hier Preis eingeben");

		filmerfassen = new Buttons("Film hinzufügen");

		speichern = new Buttons("Speichern");
		abbrechen = new Buttons("Abbrechen");
		löschen = new Buttons("Löschen");
		bearbeiten = new Buttons("Bearbeiten");

		ja = new Buttons("Ja");
		nein = new Buttons("Nein");

		ja.addActionListener(a);
		nein.addActionListener(a);

		filmerfassen.addActionListener(a);
		löschen.addActionListener(a);
		speichern.addActionListener(a);
		abbrechen.addActionListener(a);

		medien.add(mediumL, BorderLayout.WEST);
		medien.add(medium, BorderLayout.CENTER);

		preise.add(preisL, BorderLayout.WEST);
		preise.add(preis, BorderLayout.CENTER);



		if (umb == null) {
			buttons.add(filmerfassen);
		}
		else {
			buttons.add(löschen);
		}
		buttons.add(speichern);
		buttons.add(abbrechen);


		setLayout(new GridLayout(3, 1));

		add(medien);
		add(preise);
		add(buttons);





	}


	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == ja) {
				umb.löschen();
				löschen2.dispose();
			}

			if (e.getSource() == nein) {
				löschen2.dispose();
				dispose();
			}



			if (e.getSource() == löschen) {

				ErfassPanel ll = new ErfassPanel(new FlowLayout());
				löschen2 = new LöschDialog("Film löschen", "Sind Sie sicher, dass Sie diesen Film löschen möchten?", SwingConstants.CENTER);
				löschen2.setLocationRelativeTo(null);
				ll.add(ja);
				ll.add(nein);
				löschen2.add(ll, BorderLayout.SOUTH);
				löschen2.setVisible(true);
			}

			if (e.getSource() == filmerfassen) {
				ume.setFilm();
			}

			if (e.getSource() == speichern) {

				try {

					if (umb == null) {
						ume.setMedium(medium.getSelectedItem().toString());
						ume.setPreis(Integer.parseInt(preis.getText()));
						ume.speichern();
					}
					else {
						umb.setMedium(medium.getSelectedItem().toString());
						umb.setPreis(Integer.parseInt(preis.getText()));
						umb.speichern();
					}
					dispose();
				} catch (NumberFormatException exception) {

					zahl = new JDialog();
					zahl.setTitle("Bitte Zahl eingeben");
					zahl.setVisible(true);
					zahl.add(new ErfassLabel("Bitte Zahl eingeben!", SwingConstants.CENTER), BorderLayout.CENTER);
					zahl.add(ok, BorderLayout.SOUTH);
					zahl.setSize(300, 150);
					zahl.setModal(true);
					zahl.setLocationRelativeTo(null);
					zahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}
			}
			
			if (e.getSource() == ok) {
				zahl.dispose();
			}

			if (e.getSource() == abbrechen) {
				dispose();
			}

		}

	}



}
