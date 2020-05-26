package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import filme.Film;
import filme.Medienliste;
import filme.UC_Medium_ausleihen;
import kunden.Kunde;
import kunden.Kundenliste;
import kunden.UC_Kunde_suchen;

public class Film_anzeigen extends JFrame {
	
	private JComboBox<String> auswahl;
	private JLabel mediumL;
	
	private Medienliste ml;
	
	private Film f;
	
	private Kunde k;
	
	private String m;
	
	private JButton abbrechen2;
	private JButton ok;
	
	private Kunde_suchen ks;
	
	private UC_Kunde_suchen ucks;
	
	private Kundenliste kl;
	
	private UC_Medium_ausleihen ucma;
	
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
	
	private String [] ausws;
	
	private JDialog medium;
	
	private boolean mediumE;
	
	
	
	public Film_anzeigen(Film f, Kunde k, Kundenliste kl, Medienliste ml, boolean mediumE) {
		super("Filminformationen");
		
		a = new ActionHandler();
		
		this.f = f;
		this.k = k;

		this.kl = kl;
		this.ml = ml;
		
		this.mediumE = mediumE;
		
		
		
		mediumL = new JLabel("Medium");
		
		abbrechen2 = new JButton("Abbrechen");
		ok = new JButton ("Ok");
		
		abbrechen2.addActionListener(a);
		ok.addActionListener(a);
		
		ausws = new String [] {"DVD","Blu-Ray","VHS"};
		
		auswahl = new JComboBox<String>(ausws);
		
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
		if(!mediumE) {
		buttons.add(ausleihen);
		}
		
		add(angaben, BorderLayout.NORTH);
		add(buttons, BorderLayout.SOUTH);
		
		
		
	}
	



	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == abbrechen) {
				dispose();
			}
			
			if (e.getSource() == abbrechen2) {
				medium.dispose();
			}
			
			if (e.getSource() == ok) {
				m = auswahl.getSelectedItem().toString();
				medium.setVisible(false);
				k = ucks.getKs().getK();								
				ucma = new UC_Medium_ausleihen(m,k,f,ml,kl);
				ucma.setK(k);
				ucma.ausleihen();
				
			}
			
			if (e.getSource() == ausleihen) {
				
				
				
				medium = new JDialog();
				
				JPanel suche = new JPanel();
				JPanel buttons = new JPanel();
				suche.setLayout(new FlowLayout());
				buttons.setLayout(new FlowLayout());
				
				suche.add(mediumL);
				suche.add(auswahl);
				
				buttons.add(abbrechen2);
				buttons.add(ok);
				
				
				medium.setTitle("Medium auswählen");
				medium.setLayout(new GridLayout(2,1));
				medium.add(suche);
				medium.add(buttons);
				
				medium.setVisible(true);
				medium.setSize(300, 150);
				medium.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ucks = new UC_Kunde_suchen(kl, true);
				
						
				dispose();
			}
			
		}
		
	}

}
