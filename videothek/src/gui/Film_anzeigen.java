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

import controller.UC_Film_bearbeiten;
import controller.UC_Kunde_suchen;
import controller.UC_Medium_ausleihen;
import model.Film;
import model.Filmliste;
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


		ImageIcon icon = new ImageIcon(f.getHülle());

		ok2 = new Buttons();
		ok2.setText("Ok");


		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 200, 300,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );

		hülle = new ErfassLabel(icon);


		mediumL = new ErfassLabel("Medium", SwingConstants.CENTER);

		abbrechen2 = new Buttons("Abbrechen");

		ok = new Buttons ("Ok");

		abbrechen2.addActionListener(a);
		ok.addActionListener(a);
		ok2.addActionListener(a);
		ausws = new String [] {"Blu-Ray", "DVD", "VHS"};

		auswahl = new JComboBox<String>(ausws);

		angaben = new ErfassPanel();
		buttons = new ErfassPanel();
		bild = new ErfassPanel();
		bild.add(hülle, BorderLayout.CENTER);

		idL = new ErfassLabel("ID", SwingConstants.CENTER);
		lagerL = new ErfassLabel("Lager",  SwingConstants.CENTER);
		verfügbarkeitL = new ErfassLabel("Verfügbar ab", SwingConstants.CENTER);

		titel = new ErfassLabel("Titel", SwingConstants.CENTER);
		jahr = new ErfassLabel("Jahr",  SwingConstants.CENTER);
		genre = new ErfassLabel("Genre", SwingConstants.CENTER);
		beschreibung = new ErfassLabel("Beschreibung",  SwingConstants.CENTER);

		titelT = new ErfassLabel(f.getTitel(),  SwingConstants.CENTER);
		jahrT = new ErfassLabel(Integer.toString(f.getJahr()),  SwingConstants.CENTER);
		genreT = new ErfassLabel(f.getGenre(),  SwingConstants.CENTER);
		beschreibungT = new ErfassLabel(f.getBeschreibung(),  SwingConstants.CENTER);
		


		gl = new GridLayout(7, 2);
		fl = new FlowLayout();

		angaben.setLayout(gl);
		buttons.setLayout(fl);

		abbrechen = new Buttons("Abbrechen");
		ausleihen = new Buttons("Ausleihen");
		bearbeiten = new Buttons("Bearbeiten");

		abbrechen.addActionListener(a);
		ausleihen.addActionListener(a);
		bearbeiten.addActionListener(a);


		if (media != null) {


			id = new ErfassLabel(Integer.toString(media.getId()), SwingConstants.CENTER);

			if (media.isLagernd()) {
				lager = new ErfassLabel("Ja", SwingConstants.CENTER);
			}
			else {
				lager = new ErfassLabel("Nein", SwingConstants.CENTER);
			}
			if (media.getRückgabedatum() != null) {
				verfügbarkeit = new ErfassLabel (media.getRückgabedatum().toString(),SwingConstants.CENTER);
			}
			else {
				verfügbarkeit = new ErfassLabel("Sofort", SwingConstants.CENTER);

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


		buttons.add(abbrechen);
		if(!mediumE) {
			buttons.add(ausleihen);
			buttons.add(bearbeiten);
		}

		bild.setLayout(new FlowLayout());



		add(angaben, BorderLayout.WEST);
		add(bild,BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);



	}


	public void setMedia(Medium media) {
		this.media = media;
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
			
			if (e.getSource() == bearbeiten) {
				ucfb = new UC_Film_bearbeiten(fl2, ml, kl, f);
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
					ucks = new UC_Kunde_suchen(kl, true);
				}

				dispose();
			}

		}

	}

}
