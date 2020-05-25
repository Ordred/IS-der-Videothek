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

import filme.Film;

public class Film_anzeigen extends JFrame {
	
	private Film f;
	
	private ActionHandler a;
	
	private GridLayout gl;
	private FlowLayout fl;
	
	private JPanel angaben;
	private JPanel buttons;
	
	private JLabel titel;
	private JLabel jahr;
	private JLabel genre;
	private JLabel beschreibung;
	
	private JLabel titelT;
	private JLabel jahrT;
	private JLabel genreT;
	private JLabel beschreibungT;
	
	private JButton ausleihen;
	private JButton abbrechen;
	
	public Film_anzeigen(Film f) {
		super("Filminformationen");
		
		a = new ActionHandler();
		
		this.f = f;
		
		
		angaben = new JPanel();
		buttons = new JPanel();
		
		titel = new JLabel("Titel");
		jahr = new JLabel("Jahr");
		genre = new JLabel("Genre");
		beschreibung = new JLabel("Beschreibung");
		
		titelT = new JLabel(f.getTitel());
		jahrT = new JLabel(Integer.toString(f.getJahr()));
		genreT = new JLabel(f.getGenre());
		beschreibungT = new JLabel(f.getBeschreibung());
		
		
		gl = new GridLayout(4, 2);
		fl = new FlowLayout();
		
		angaben.setLayout(gl);
		buttons.setLayout(fl);
		
		abbrechen = new JButton("Abbrechen");
		ausleihen = new JButton("Ausleihen");
		
		abbrechen.addActionListener(a);
		ausleihen.addActionListener(a);
		
		angaben.add(titel);
		angaben.add(titelT);
		angaben.add(jahr);
		angaben.add(jahrT);
		angaben.add(genre);
		angaben.add(genreT);
		angaben.add(beschreibung);
		angaben.add(beschreibungT);
		
		buttons.add(abbrechen);
		buttons.add(ausleihen);
		
		add(angaben, BorderLayout.NORTH);
		add(buttons, BorderLayout.SOUTH);
		
		
		
	}
	
	
	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == abbrechen) {
				dispose();
			}
			
			if (e.getSource() == ausleihen) {
				System.out.println("geht noch nicht");
			}
			
			
		}
		
	}

}
