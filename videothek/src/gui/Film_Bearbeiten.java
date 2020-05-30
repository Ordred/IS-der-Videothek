package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.buttons;
import javax.swing.JFrame;
import javax.swing.erfassLabel;
import javax.swing.erfassPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.UC_Film_bearbeiten;
import controller.UC_Film_erfassen;
import gui_elemente.Buttons;
import gui_elemente.ErfassFrame;
import gui_elemente.ErfassLabel;
import gui_elemente.ErfassPanel;
import gui_elemente.LöschDialog;

public class Film_Bearbeiten extends ErfassFrame{

	/* JFilechooser */
	
	private UC_Film_bearbeiten ucfb;
	
	private JTextField titel;
	private JTextField jahr;
	private JTextField genre;
	private JTextField beschreibung;
	
	private ErfassLabel titelL;
	private ErfassLabel jahrL;
	private ErfassLabel genreL;
	private ErfassLabel beschreibungL;
	
	private ErfassPanel buttons;
	private ErfassPanel form;
	
	private GridLayout gl1;
	
	private FlowLayout fl;
	
	private Buttons speichern;
	private Buttons abbrechen;
	private Buttons löschen;
	private Buttons bildwählen;
	
	private Buttons ja;
	private Buttons nein;
	
	private ActionHandler a;
	private JFileChooser datei;
	private String icS;
	
	private JDialog zahl;
	private Buttons ok;
	
	private LöschDialog löschen2;	
	
	public Film_Bearbeiten(UC_Film_bearbeiten ucfb) {
		
		super("Film bearbeiten");
		
		
				
	
		this.ucfb = ucfb;
		
		ok = new Buttons("Ok");
		
		
		
		a = new ActionHandler();
		
		form = new ErfassPanel(null);
		buttons = new ErfassPanel(null);
		
		gl1 = new GridLayout(4,2);
		fl = new FlowLayout();
		
		form.setLayout(gl1);
		buttons.setLayout(fl);
		
		speichern = new Buttons("Speichern");
		abbrechen = new Buttons("Abbrechen");
		löschen = new Buttons("Löschen");
		bildwählen = new Buttons("Bild auswählen");
		
		ja = new Buttons("Ja");
		nein = new Buttons("Nein");
		
		titel = new JTextField(ucfb.getF().getTitel());
		jahr = new JTextField(ucfb.getF().getJahr());
		genre = new JTextField(ucfb.getF().getGenre());
		beschreibung = new JTextField(ucfb.getF().getBeschreibung());
		icS = ucfb.getF().getHülle();
		
		titelL = new ErfassLabel("Titel", SwingConstants.CENTER);
		jahrL = new ErfassLabel("Jahr", SwingConstants.CENTER);
		genreL = new ErfassLabel("Genre", SwingConstants.CENTER);
		beschreibungL = new ErfassLabel("Beschreibung", SwingConstants.CENTER);
		
		titel.addActionListener(a);
		jahr.addActionListener(a);
		genre.addActionListener(a);
		beschreibung.addActionListener(a);
		bildwählen.addActionListener(a);
		
		speichern.addActionListener(a);
		abbrechen.addActionListener(a);
		löschen.addActionListener(a);
		
		ja.addActionListener(a);
		nein.addActionListener(a);
		
		ok.addActionListener(a);
		
		form.add(titelL);
		form.add(titel);
		form.add(jahrL);
		form.add(jahr);
		form.add(genreL);
		form.add(genre);
		form.add(beschreibungL);
		form.add(beschreibung);
		
		
		buttons.add(abbrechen);
		buttons.add(bildwählen);
		buttons.add(löschen);
		buttons.add(speichern);
		
		add(form, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);


	}
	
	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == abbrechen) {
				dispose();
			}
			
			if (e.getSource() == nein) {
				löschen2.dispose();
			}
			
			if (e.getSource() == ja) {
				ucfb.löschen();
			}
			
			if (e.getSource() == bildwählen) {
				datei = new JFileChooser();
				datei.setName("Bild wählen");
				
				int result = datei.showOpenDialog(new JDialog());
				
				if (result == JFileChooser.APPROVE_OPTION) {
				    icS = datei.getSelectedFile().getName();
				}
				

				    
				datei.setVisible(true);
				datei.setSize(300, 300);
			}
			
			if (e.getSource() == ok) {
				zahl.dispose();
			}
			
			if (e.getSource() == speichern) {
				
				try {
				
				ucfb.setTitel(titel.getText());
				ucfb.setGenre(genre.getText());
				ucfb.setJahr(Integer.parseInt(jahr.getText()));
				ucfb.setBeschreibung(beschreibung.getText());
				ucfb.setHülle(icS);
				ucfb.speichern();

				dispose();
				} catch (NumberFormatException exception) {
					zahl = new JDialog();
					zahl.setTitle("Bitte Zahl bei Jahr eingeben");
					zahl.setVisible(true);
					zahl.add(new ErfassLabel("Bitte Zahl bei Jahr eingeben!", SwingConstants.CENTER), BorderLayout.CENTER);
					zahl.add(ok,SwingConstants.SOUTH);
					zahl.setSize(300, 150);
					zahl.setLocationRelativeTo(null);
					zahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} 
			}
			
			if (e.getSource() == löschen) {
				
				ErfassPanel ll = new ErfassPanel(new FlowLayout());
				löschen2 = new LöschDialog("Film löschen", "Sind Sie sicher, dass Sie diesen Film löschen möchten? "
						+ "Damit gehen alle damit verbundenen Medien verloren.", SwingConstants.CENTER);
				löschen2.setLocationRelativeTo(null);
				ll.add(ja);
				ll.add(nein);
				löschen2.add(ll, BorderLayout.CENTER);
				löschen2.setVisible(true);
				
				
			}
			
		}
		
	}

}
