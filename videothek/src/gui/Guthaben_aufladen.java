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

import controller.UC_Guthaben_aufladen;
import gui_elemente.Buttons;
import gui_elemente.ErfassLabel;
import gui_elemente.ErfassPanel;

public class Guthaben_aufladen extends JFrame {

	private ErfassLabel betrag;
	private JTextField eingabe;
	private Buttons abbrechen;
	private Buttons speichern;

	private ErfassPanel buttons;
	private ErfassPanel eingeben;

	private UC_Guthaben_aufladen uga;

	private ActionHandler a;
	
	private JDialog zahl;
	private Buttons ok;

	public Guthaben_aufladen(UC_Guthaben_aufladen uga) {

		super("Guthaben aufladen");



		this.uga = uga;

		a = new ActionHandler();
		
		ok = new Buttons("Ok");

		betrag = new ErfassLabel("Betrag");
		eingabe= new JTextField("Betrag eingeben");
		abbrechen = new Buttons("Abbrechen");
		speichern = new Buttons("Speichern");

		abbrechen.addActionListener(a);
		speichern.addActionListener(a);

		buttons = new ErfassPanel();
		eingeben = new ErfassPanel();

		buttons.setLayout(new FlowLayout());
		eingeben.setLayout(new FlowLayout());

		buttons.add(abbrechen);
		buttons.add(speichern);

		eingeben.add(betrag);
		eingeben.add(eingabe);

		super.setLayout(new GridLayout(1, 2));

		add(eingeben);
		add(buttons);

	}

	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {



			if (e.getSource() == abbrechen) {
				dispose();
			}

			if (e.getSource() == speichern) {
				try {
					uga.aufladen(Integer.parseInt(eingabe.getText()));

					dispose();
				} catch (NumberFormatException exception) {

					zahl = new JDialog();
					zahl.setTitle("Bitte Zahl eingeben");
					zahl.setVisible(true);
					zahl.add(new ErfassLabel("Bitte Zahl eingeben!", SwingConstants.CENTER), BorderLayout.CENTER);
					zahl.add(ok, BorderLayout.SOUTH);
					zahl.setModal(true);
					zahl.setSize(300, 150);
					zahl.setLocationRelativeTo(null);
					zahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}

			}
			
			if (e.getSource() == ok) {
				zahl.dispose();
			}

		}


	}





}
