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

public class Film_Bearbeiten extends erfassFrame{

	/* JFilechooser */
	
	private UC_Film_bearbeiten ucfb;
	
	private JTextField titel;
	private JTextField jahr;
	private JTextField genre;
	private JTextField beschreibung;
	
	private erfassLabel titelL;
	private erfassLabel jahrL;
	private erfassLabel genreL;
	private erfassLabel beschreibungL;
	
	private erfassPanel buttons;
	private erfassPanel form;
	
	private GridLayout gl1;
	
	private FlowLayout fl;
	
	private buttons speichern;
	private buttons abbrechen;
	private buttons löschen;
	private buttons bildwählen;
	
	private ActionHandler a;
	private JFileChooser datei;
	private File ic;
	

	
	
	public Film_Bearbeiten(UC_Film_bearbeiten ucfb) {
		
		super("Film bearbeiten");
		
		
				
	
		this.ucfb = ucfb;
		
		a = new ActionHandler();
		
		form = new erfassPanel(null);
		buttons = new erfassPanel(null);
		
		gl1 = new GridLayout(4,2);
		fl = new FlowLayout();
		
		form.setLayout(gl1);
		buttons.setLayout(fl);
		
		speichern = new buttons("Speichern");
		abbrechen = new buttons("Abbrechen");
		löschen = new buttons("Löschen");
		bildwählen = new buttons("Bild auswählen");
		
		titel = new JTextField("Titel");
		jahr = new JTextField("Jahr");
		genre = new JTextField("Genre");
		beschreibung = new JTextField("Beschreibung");
		
		titelL = new erfassLabel("Titel", SwingConstants.CENTER);
		jahrL = new erfassLabel("Jahr", SwingConstants.CENTER);
		genreL = new erfassLabel("Genre", SwingConstants.CENTER);
		beschreibungL = new erfassLabel("Beschreibung", SwingConstants.CENTER);
		
		titel.addActionListener(a);
		jahr.addActionListener(a);
		genre.addActionListener(a);
		beschreibung.addActionListener(a);
		bildwählen.addActionListener(a);
		
		speichern.addActionListener(a);
		abbrechen.addActionListener(a);
		löschen.addActionListener(a);
		
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
			
			if (e.getSource() == bildwählen) {
				datei = new JFileChooser();
				datei.setName("Bild wählen");
				
				int result = datei.showOpenDialog(new JDialog());
				
				if (result == JFileChooser.APPROVE_OPTION) {
				    ic = datei.getSelectedFile();
				}
				

				    
				datei.setVisible(true);
				datei.setSize(300, 300);
			}
			
			if (e.getSource() == speichern) {
				
				ucfb.setTitel(titel.getText());
				ucfb.setGenre(genre.getText());
				ucfb.setJahr(Integer.parseInt(jahr.getText()));
				ucfb.setBeschreibung(beschreibung.getText());
				ucfb.setHülle(ic.getName());
				ucfb.speichern();

				dispose();
			}
			
			if (e.getSource() == löschen) {
				ucfb.löschen();
			}
			
		}
		
	}

}
