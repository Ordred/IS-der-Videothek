package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;


import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.UC_Film_bearbeiten;
import controller.UC_Kunde_suchen;
import controller.UC_Medium_ausleihen;
import controller.UC_Medium_bearbeiten;
import gui_elemente.Buttons;
import gui_elemente.ErfassFrame;
import gui_elemente.ErfassLabel;
import gui_elemente.ErfassPanel;
import gui_elemente.LöschDialog;
import model.Film;
import model.Filmliste;
import model.Geschäftseinnahmen;
import model.Kunde;
import model.Kundenliste;
import model.Medienliste;
import model.Medium;

public class Film_anzeigen extends ErfassFrame {

	private JComboBox<String> auswahl;
	private ErfassLabel mediumL;

	private Medienliste ml;

	private Film f;

	private Kunde k;

	private String m;

	private Buttons abbrechen2;
	private Buttons ok;

	private Kunde_suchen ks;

	private UC_Kunde_suchen ucks;

	private Kundenliste kl;

	private UC_Medium_ausleihen ucma;

	private ActionHandler a;

	private GridLayout gl;
	private FlowLayout fl;

	private ErfassPanel angaben;
	private ErfassPanel buttons;

	private ErfassLabel titel;
	private ErfassLabel jahr;
	private ErfassLabel genre;
	private ErfassLabel beschreibung;
	private ErfassLabel hülle;

	private ErfassLabel titelT;
	private ErfassLabel jahrT;
	private ErfassLabel genreT;
	private ErfassLabel beschreibungT;

	private Buttons ausleihen;
	private Buttons abbrechen;
	private Buttons bearbeiten;

	private String [] ausws;

	private JDialog medium;

	private boolean mediumE;

	private Medium media;

	private ErfassLabel idL;
	private ErfassLabel id;
	private ErfassLabel lagerL;
	private ErfassLabel lager;
	private ErfassLabel verfügbarkeitL;
	private ErfassLabel verfügbarkeit;

	private String verf;
	private ErfassPanel bild;

	private Buttons ok2;

	private ErfassFrame kG;
	private UC_Film_bearbeiten ucfb;
	private Filmliste fl2;

	private ErfassLabel brL;
	private ErfassLabel dvdL;
	private ErfassLabel vhsL;

	private ErfassLabel br;
	private ErfassLabel dvd;
	private ErfassLabel vhs;

	private ErfassPanel oben;
	private UC_Medium_bearbeiten umb;
	private Buttons ok3;
	private LöschDialog nichtLager;

	private Film_anzeigen fa;

	private Buttons ausleihen2;



	public Film_anzeigen(Film f, Kunde k, Filmliste fl2, Kundenliste kl, Medienliste ml, boolean mediumE, Medium media) {
		super("");



		if (media == null) {
			super.setTitle("Filminformationen");
		}

		else {
			super.setTitle("Medieninformationen");
		}


		a = new ActionHandler();

		this.f = f;
		this.k = k;

		this.kl = kl;
		this.ml = ml;
		this.fl2 = fl2;

		this.media = media;

		this.mediumE = mediumE;

		brL = new ErfassLabel("Blu-Ray", SwingConstants.LEFT);
		dvdL = new ErfassLabel("DVD", SwingConstants.LEFT);
		vhsL = new ErfassLabel("VHS", SwingConstants.LEFT);

		br = new ErfassLabel("Nein", SwingConstants.LEFT);
		dvd = new ErfassLabel("Nein", SwingConstants.LEFT);
		vhs = new ErfassLabel("Nein", SwingConstants.LEFT);

		oben = new ErfassPanel(new GridLayout(1, 2));
		
		for (int i = 0; i < ml.getMedienliste().size(); i++) {
			if (f.getId().equalsIgnoreCase(ml.getMedienliste().get(i).getFilm().getId())) {
				if (media == null) { 
				media = ml.getMedienliste().get(i);
				}
				if (media.getMedium().equalsIgnoreCase("Blu-Ray") && media.isLagernd()) {
					br.setText("Ja");
				}
				if (media.getMedium().equalsIgnoreCase("DVD") && media.isLagernd()) {
					dvd.setText("Ja");
				}
				if (media.getMedium().equalsIgnoreCase("VHS") && media.isLagernd()) {
					vhs.setText("Ja");
				}
				
			}
		}



		ImageIcon icon = new ImageIcon(f.getHülle());

		ok2 = new Buttons();
		ok2.setText("Ok");

		ok3 = new Buttons("Ok");


		ausleihen2 = new Buttons("Ausleihen");


		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 200, 300,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );

		hülle = new ErfassLabel(icon);

		hülle.setBorder(new EtchedBorder(Color.yellow, Color.DARK_GRAY));

		mediumL = new ErfassLabel("Medium", SwingConstants.CENTER);

		abbrechen2 = new Buttons("Abbrechen");

		ok = new Buttons ("Ok");

		abbrechen2.addActionListener(a);
		ok.addActionListener(a);
		ok2.addActionListener(a);
		ok3.addActionListener(a);
		ausws = new String [] {"Blu-Ray", "DVD", "VHS"};

		auswahl = new JComboBox<String>(ausws);

		angaben = new ErfassPanel();
		buttons = new ErfassPanel();
		bild = new ErfassPanel();
		bild.add(hülle, BorderLayout.CENTER);

		idL = new ErfassLabel("ID", SwingConstants.LEFT);
		lagerL = new ErfassLabel("Lager",  SwingConstants.LEFT);
		verfügbarkeitL = new ErfassLabel("Verfügbar ab", SwingConstants.LEFT);

		titel = new ErfassLabel("Titel", SwingConstants.LEFT);
		jahr = new ErfassLabel("Jahr",  SwingConstants.LEFT);
		genre = new ErfassLabel("Genre", SwingConstants.LEFT);
		beschreibung = new ErfassLabel("Beschreibung",  SwingConstants.LEFT);

		titelT = new ErfassLabel(f.getTitel(),  SwingConstants.LEFT);
		jahrT = new ErfassLabel(Integer.toString(f.getJahr()),  SwingConstants.LEFT);
		genreT = new ErfassLabel(f.getGenre(),  SwingConstants.LEFT);
		beschreibungT = new ErfassLabel(f.getBeschreibung(),  SwingConstants.LEFT);



		gl = new GridLayout(10, 2);
		fl = new FlowLayout();

		angaben.setLayout(gl);
		buttons.setLayout(fl);

		abbrechen = new Buttons("Abbrechen");
		ausleihen = new Buttons("Ausleihen");
		bearbeiten = new Buttons("Bearbeiten");

		abbrechen.addActionListener(a);
		ausleihen.addActionListener(a);
		ausleihen2.addActionListener(a);
		bearbeiten.addActionListener(a);


		if (media != null) {


			id = new ErfassLabel(media.getId(), SwingConstants.LEFT);

			if (media.isLagernd()) {
				lager = new ErfassLabel("Ja", SwingConstants.LEFT);
			}
			else {
				lager = new ErfassLabel("Nein", SwingConstants.LEFT);
			}
			if (media.getRückgabedatum() != null) {
				verfügbarkeit = new ErfassLabel (media.getRückgabedatum().toString(),SwingConstants.LEFT);
			}
			else {
				verfügbarkeit = new ErfassLabel("Sofort", SwingConstants.LEFT);

			}

			angaben.add(idL);
			angaben.add(id);
			angaben.add(lagerL);
			angaben.add(lager);
			angaben.add(verfügbarkeitL);
			angaben.add(verfügbarkeit);
		}

		angaben.add(titel);
		angaben.add(titelT);
		angaben.add(jahr);
		angaben.add(jahrT);
		angaben.add(genre);
		angaben.add(genreT);
		angaben.add(beschreibung);
		angaben.add(beschreibungT);
		angaben.add(brL);
		angaben.add(br);
		angaben.add(dvdL);
		angaben.add(dvd);
		angaben.add(vhsL);
		angaben.add(vhs);


		buttons.add(abbrechen);
		if(!mediumE) {
			if (media == null) {
				buttons.add(ausleihen);
			}
			else {

			}
			if (k == null) {
				buttons.add(bearbeiten);
			}
		}

		bild.setLayout(new FlowLayout());

		oben.add(angaben);
		oben.add(bild);


		add(oben,BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);



	}


	public void setMedia(Medium media) {
		this.media = media;
	}





	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {


			titelT = new ErfassLabel(f.getTitel(),  SwingConstants.LEFT);
			jahrT = new ErfassLabel(Integer.toString(f.getJahr()),  SwingConstants.LEFT);
			genreT = new ErfassLabel(f.getGenre(),  SwingConstants.LEFT);
			beschreibungT = new ErfassLabel(f.getBeschreibung(),  SwingConstants.LEFT);

			if (media != null) {


				id = new ErfassLabel(media.getId(), SwingConstants.LEFT);

				if (media.isLagernd()) {
					lager = new ErfassLabel("Ja", SwingConstants.LEFT);
				}
				else {
					lager = new ErfassLabel("Nein", SwingConstants.LEFT);
				}
				if (media.getRückgabedatum() != null) {
					verfügbarkeit = new ErfassLabel (media.getRückgabedatum().toString(),SwingConstants.LEFT);
				}
				else {
					verfügbarkeit = new ErfassLabel("Sofort", SwingConstants.LEFT);

				}
			}

			if (e.getSource() == abbrechen) {
				dispose();
			}

			if (e.getSource() == abbrechen2) {
				medium.dispose();
			}

			for (int i = 0; i < ml.getMedienliste().size(); i++) {
				if (ml.getMedienliste().get(i).getMedium().equalsIgnoreCase("Blu-Ray") && ml.getMedienliste().get(i).isLagernd()) {
					br.setText("Ja");
				}
				if (ml.getMedienliste().get(i).getMedium().equalsIgnoreCase("DVD") && ml.getMedienliste().get(i).isLagernd()) {
					dvd.setText("Ja");
				}
				if (ml.getMedienliste().get(i).getMedium().equalsIgnoreCase("VHS") && ml.getMedienliste().get(i).isLagernd()) {
					vhs.setText("Ja");
				}
			}

			angaben.validate();
			angaben.repaint();


			if (e.getSource() == bearbeiten) {
				if (media == null) {
					ucfb = new UC_Film_bearbeiten(fl2, ml, kl, f);
				}
				else {
					umb = new UC_Medium_bearbeiten(media, ml, fl2, kl);
				}
				dispose();
			}

			if (e.getSource() == ok) {
				m = auswahl.getSelectedItem().toString();
				medium.setVisible(false);

				if (media == null) {

					for (int i = 0; i < ml.getMedienliste().size(); i++) {
						if (ml.getMedienliste().get(i).getFilm().getId() == f.getId() && ml.getMedienliste().get(i).getMedium().equalsIgnoreCase(m)) {
							media = ml.getMedienliste().get(i);
							System.out.println("medium gesetzt");
						}
					}
				}

				if (k == null) {
					k = ucks.getKs().getK();
				}


				ucma = new UC_Medium_ausleihen(m,k,f,ml,kl, media);

				if (media != null) {
					if(k.getGuthaben() >= -media.getPreis()) {
						ml.laden();
						ucma.ausleihen();
					}

					else {
						kG = new ErfassFrame("Zu wenig Guthaben");

						kG.setVisible(true);
						kG.setSize(300, 150);
						kG.setLocationRelativeTo(null);
						kG.add(new ErfassLabel("Zu wenig Guthaben!"), BorderLayout.CENTER);
						kG.add(ok2, BorderLayout.SOUTH);
					}
				}
				else {
					nichtLager = new LöschDialog("Nicht lagernd", "Dieser Film ist in diesem Medium derzeit nicht an Lager", SwingConstants.CENTER);
					nichtLager.add(ok3, BorderLayout.SOUTH);
					nichtLager.setVisible(true);
					nichtLager.setLocationRelativeTo(null);
				}



			}

			if (e.getSource() == ok3) {
				nichtLager.dispose();
			}


			if (e.getSource() == ok2) {
				kG.dispose();
			}

			if (e.getSource() == ausleihen) {



				medium = new JDialog();

				ErfassPanel suche = new ErfassPanel();
				ErfassPanel buttons = new ErfassPanel();
				suche.setLayout(new FlowLayout());
				buttons.setLayout(new FlowLayout());

				suche.add(mediumL);
				suche.add(auswahl);

				buttons.add(abbrechen2);
				buttons.add(ok);

				if (media == null) {
					medium.setTitle("Medium auswählen");
					medium.setLayout(new GridLayout(2,1));
					medium.add(suche);
					medium.add(buttons);

					medium.setVisible(true);
					medium.setSize(300, 150);

					medium.setLocationRelativeTo(null);

					medium.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


					setLocationRelativeTo(null);
				}

				if (k == null) {
					Geschäftseinnahmen ge = new Geschäftseinnahmen();
					ge.laden();
					ucks = new UC_Kunde_suchen(ge, kl, true, this);
				}

			}

			if (e.getSource() == ausleihen2) {
				Geschäftseinnahmen ge = new Geschäftseinnahmen();
				ge.laden();
				ucks = new UC_Kunde_suchen(ge, kl, true, this);	


				if (ucks.getKs().getK() != null && media != null) {

					k = ucks.getKs().getK();
					ucma = new UC_Medium_ausleihen(m,k,f,ml,kl, media);


					if(k.getGuthaben() >= -media.getPreis()) {
						ml.laden();
						ucma.ausleihen();

						System.out.println("ausleihen gestartet");
					}

					else {
						kG = new ErfassFrame("Zu wenig Guthaben");

						kG.setVisible(true);
						kG.setSize(300, 150);
						kG.setLocationRelativeTo(null);
						kG.add(new ErfassLabel("Zu wenig Guthaben!"), BorderLayout.CENTER);
						kG.add(ok2, BorderLayout.SOUTH);

					}
				}

			}

		}





		public Kunde getK() {
			return k;
		}


		public Medium getMedia() {
			return media;
		}

		public void setK(Kunde k2) {
			k = k2;

			System.out.println(k);
			System.out.println(media);



			ucma = new UC_Medium_ausleihen(m,k,f,ml,kl, media);


			if(k.getGuthaben() >= -media.getPreis()) {
				ml.laden();
				ucma.ausleihen();

				System.out.println("ausleihen gestartet");
			}

			else {
				kG = new ErfassFrame("Zu wenig Guthaben");

				kG.setVisible(true);
				kG.setSize(300, 150);
				kG.setLocationRelativeTo(null);
				kG.add(new ErfassLabel("Zu wenig Guthaben!"), BorderLayout.CENTER);
				kG.add(ok2, BorderLayout.SOUTH);
			}

		}

	}



}


