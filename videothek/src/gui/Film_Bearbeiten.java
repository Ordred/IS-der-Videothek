package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.UC_Film_bearbeiten;
import controller.UC_Film_erfassen;

public class Film_Bearbeiten extends JFrame{

	/* JFilechooser */
	
	private UC_Film_bearbeiten ucfb;
	
	private JTextField titel;
	private JTextField jahr;
	private JTextField genre;
	private JTextField beschreibung;
	
	private JLabel titelL;
	private JLabel jahrL;
	private JLabel genreL;
	private JLabel beschreibungL;
	
	private JPanel buttons;
	private JPanel form;
	
	private GridLayout gl1;
	
	private FlowLayout fl;
	
	private JButton speichern;
	private JButton abbrechen;
	private JButton löschen;
	
	private ActionHandler a;
	
	
	public Film_Bearbeiten(UC_Film_bearbeiten ucfb) {
		
		super("Film erfassen");
		
		
	
		this.ucfb = ucfb;
		
		a = new ActionHandler();
		
		gl1 = new GridLayout(4,2);
		fl = new FlowLayout();
		
		form = new JPanel(gl1);
		buttons = new JPanel(fl);
		
		speichern = new JButton("Speichern");
		abbrechen = new JButton("Abbrechen");
		löschen = new JButton("Löschen");
		
		
		titel = new JTextField("Titel");
		jahr = new JTextField("Jahr");
		genre = new JTextField("Genre");
		beschreibung = new JTextField("Beschreibung");
		
		titelL = new JLabel("Titel");
		jahrL = new JLabel("Jahr");
		genreL = new JLabel("Genre");
		beschreibungL = new JLabel("Beschreibung");
		
		titel.addActionListener(a);
		jahr.addActionListener(a);
		genre.addActionListener(a);
		beschreibung.addActionListener(a);
		
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
		
		buttons.add(abbrechen, BorderLayout.WEST);
		buttons.add(löschen, BorderLayout.CENTER);
		buttons.add(speichern, BorderLayout.EAST);
		
		
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
			
			if (e.getSource() == speichern) {
				
				ucfb.setTitel(titel.getText());
				ucfb.setGenre(genre.getText());
				ucfb.setJahr(Integer.parseInt(jahr.getText()));
				ucfb.setBeschreibung(beschreibung.getText());
				ucfb.speichern();

				dispose();
			}
			
			if (e.getSource() == löschen) {
				ucfb.löschen();
			}
			
		}
		
	}

}
