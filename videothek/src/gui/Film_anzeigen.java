package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;


import javax.swing.SwingConstants;

import controller.UC_Kunde_suchen;
import controller.UC_Medium_ausleihen;
import model.Film;
import model.Kunde;
import model.Kundenliste;
import model.Medienliste;
import model.Medium;

public class Film_anzeigen extends erfassFrame {

	private JComboBox<String> auswahl;
	private erfassLabel mediumL;

	private Medienliste ml;

	private Film f;

	private Kunde k;

	private String m;

	private buttons abbrechen2;
	private buttons ok;

	private Kunde_suchen ks;

	private UC_Kunde_suchen ucks;

	private Kundenliste kl;

	private UC_Medium_ausleihen ucma;

	private ActionHandler a;

	private GridLayout gl;
	private FlowLayout fl;

	private erfassPanel angaben;
	private erfassPanel buttons;

	private erfassLabel titel;
	private erfassLabel jahr;
	private erfassLabel genre;
	private erfassLabel beschreibung;
	private erfassLabel h�lle;

	private erfassLabel titelT;
	private erfassLabel jahrT;
	private erfassLabel genreT;
	private erfassLabel beschreibungT;

	private buttons ausleihen;
	private buttons abbrechen;

	private String [] ausws;

	private JDialog medium;

	private boolean mediumE;

	private Medium media;

	private erfassLabel idL;
	private erfassLabel id;
	private erfassLabel lagerL;
	private erfassLabel lager;
	private erfassLabel verf�gbarkeitL;
	private erfassLabel verf�gbarkeit;

	private String verf;
	private erfassPanel bild;



	public Film_anzeigen(Film f, Kunde k, Kundenliste kl, Medienliste ml, boolean mediumE, Medium media) {
		super("");
		
		
		
		setSize(500, 400);
		if (media == null) {
			super.setTitle("Filminformationen");
		}

		else {
			super.setTitle("Medieninformationen");
		}
		
		setLocationRelativeTo(null);
		a = new ActionHandler();

		this.f = f;
		this.k = k;

		this.kl = kl;
		this.ml = ml;

		this.media = media;

		this.mediumE = mediumE;

		
		ImageIcon icon = new ImageIcon(f.getH�lle());

		
		
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 200, 300,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );

		h�lle = new erfassLabel(icon);
		
		
		mediumL = new erfassLabel("Medium", SwingConstants.CENTER);
	
		abbrechen2 = new buttons("Abbrechen");

		ok = new buttons ("Ok");

		abbrechen2.addActionListener(a);
		ok.addActionListener(a);

		ausws = new String [] {"DVD","Blu-Ray","VHS"};

		auswahl = new JComboBox<String>(ausws);

		angaben = new erfassPanel();
		buttons = new erfassPanel();
		bild = new erfassPanel();
		bild.add(h�lle, BorderLayout.CENTER);

		idL = new erfassLabel("ID", SwingConstants.LEFT);
		lagerL = new erfassLabel("Lager",  SwingConstants.LEFT);
		verf�gbarkeitL = new erfassLabel("Verf�gbar ab", SwingConstants.LEFT);

		titel = new erfassLabel("Titel", SwingConstants.LEFT);
		jahr = new erfassLabel("Jahr",  SwingConstants.LEFT);
		genre = new erfassLabel("Genre", SwingConstants.LEFT);
		beschreibung = new erfassLabel("Beschreibung                ",  SwingConstants.LEFT);

		titelT = new erfassLabel(f.getTitel(),  SwingConstants.RIGHT);
		jahrT = new erfassLabel(Integer.toString(f.getJahr()),  SwingConstants.RIGHT);
		genreT = new erfassLabel(f.getGenre(),  SwingConstants.RIGHT);
		beschreibungT = new erfassLabel(f.getBeschreibung(),  SwingConstants.RIGHT);


		gl = new GridLayout(7, 2);
		fl = new FlowLayout();

		angaben.setLayout(gl);
		buttons.setLayout(fl);

		abbrechen = new buttons("Abbrechen");
		ausleihen = new buttons("Ausleihen");

		abbrechen.addActionListener(a);
		ausleihen.addActionListener(a);


		if (media != null) {
			
			
			id = new erfassLabel(Integer.toString(media.getId()), SwingConstants.RIGHT);

			if (media.isLagernd()) {
				lager = new erfassLabel("Ja", SwingConstants.RIGHT);
			}
			else {
				lager = new erfassLabel("Nein", SwingConstants.RIGHT);
			}
			if (media.getR�ckgabedatum() != null) {
			verf�gbarkeit = new erfassLabel (media.getR�ckgabedatum().toString(),SwingConstants.RIGHT);
			}
			else {
				verf�gbarkeit = new erfassLabel("Sofort", SwingConstants.RIGHT);
			}
			
			angaben.add(idL);
			angaben.add(id);
			angaben.add(lagerL);
			angaben.add(lager);
			angaben.add(verf�gbarkeitL);
			angaben.add(verf�gbarkeit);
		}
		
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
		
		bild.setLayout(new FlowLayout());
		
		

		add(angaben, BorderLayout.WEST);
		add(bild,BorderLayout.CENTER);
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

				if (k == null) {
					k = ucks.getKs().getK();
				}
				ucma = new UC_Medium_ausleihen(m,k,f,ml,kl, media);
				
				if (media != null) {
					ucma.setM(media);
				}
				
				ml.laden();

				ucma.ausleihen();

			}

			if (e.getSource() == ausleihen) {



				medium = new JDialog();

				erfassPanel suche = new erfassPanel();
				erfassPanel buttons = new erfassPanel();
				suche.setLayout(new FlowLayout());
				buttons.setLayout(new FlowLayout());

				suche.add(mediumL);
				suche.add(auswahl);

				buttons.add(abbrechen2);
				buttons.add(ok);


				medium.setTitle("Medium ausw�hlen");
				medium.setLayout(new GridLayout(2,1));
				medium.add(suche);
				medium.add(buttons);

				medium.setVisible(true);
				medium.setSize(300, 150);
				
				
				medium.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				
				setLocationRelativeTo(null);
				if (k == null) {
					ucks = new UC_Kunde_suchen(kl, true);
				}

				dispose();
			}

		}

	}

}
