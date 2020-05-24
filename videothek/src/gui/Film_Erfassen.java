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

import filme.UC_Film_erfassen;

public class Film_Erfassen extends JFrame{
	
	UC_Film_erfassen ufe;
	
	JTextField titel;
	JTextField jahr;
	JTextField genre;
	JTextField beschreibung;
	
	JLabel titelL;
	JLabel jahrL;
	JLabel genreL;
	JLabel beschreibungL;
	
	JPanel buttons;
	JPanel form;
	
	GridLayout gl1;
	GridLayout gl2;
	GridLayout gl3;
	
	FlowLayout fl;
	
	JButton speichern;
	JButton abbrechen;
	
	ActionHandler a;
	
	
	public Film_Erfassen(UC_Film_erfassen ufe) {
		
		super("Film erfassen");
		
		this.ufe = ufe;
		
		a = new ActionHandler();
		
		gl1 = new GridLayout(4,2);
		fl = new FlowLayout();
		
		form = new JPanel(gl1);
		buttons = new JPanel(fl);
		
		speichern = new JButton("Speichern");
		abbrechen = new JButton("Abbrechen");
		
		
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

		form.add(titelL);
		form.add(titel);
		form.add(jahrL);
		form.add(jahr);
		form.add(genreL);
		form.add(genre);
		form.add(beschreibungL);
		form.add(beschreibung);
		
		buttons.add(abbrechen, BorderLayout.WEST);
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
				
				ufe.setTitel(titel.getText());
				ufe.setGenre(genre.getText());
				ufe.setJahr(Integer.parseInt(jahr.getText()));
				ufe.setBeschreibung(beschreibung.getText());
				ufe.speichern();

				dispose();
			}
			
		}
		
	}

}
