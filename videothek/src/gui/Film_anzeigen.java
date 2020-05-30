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
	private erfassLabel hülle;

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
	private erfassLabel verfügbarkeitL;
	private erfassLabel verfügbarkeit;

	private String verf;
	private erfassPanel bild;

	private buttons ok2;
	private erfassFrame kG;



	public Film_anzeigen(Film f, Kunde k, Kundenliste kl, Medienliste ml, boolean mediumE, Medium media) {
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

		this.media = media;

		this.mediumE = mediumE;


		ImageIcon icon = new ImageIcon(f.getHülle());

		ok2 = new buttons();
		ok2.setText("Ok");


		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 200, 300,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );

		hülle = new erfassLabel(icon);


		mediumL = new erfassLabel("Medium", SwingConstants.CENTER);

		abbrechen2 = new buttons("Abbrechen");

		ok = new buttons ("Ok");

		abbrechen2.addActionListener(a);
		ok.addActionListener(a);
		ok2.addActionListener(a);
		ausws = new String [] {"Blu-Ray", "DVD", "VHS"};

		auswahl = new JComboBox<String>(ausws);

		angaben = new erfassPanel();
		buttons = new erfassPanel();
		bild = new erfassPanel();
		bild.add(hülle, BorderLayout.CENTER);

		idL = new erfassLabel("ID", SwingConstants.CENTER);
		lagerL = new erfassLabel("Lager",  SwingConstants.CENTER);
		verfügbarkeitL = new erfassLabel("Verfügbar ab", SwingConstants.CENTER);

		titel = new erfassLabel("Titel", SwingConstants.CENTER);
		jahr = new erfassLabel("Jahr",  SwingConstants.CENTER);
		genre = new erfassLabel("Genre", SwingConstants.CENTER);
		beschreibung = new erfassLabel("Beschreibung",  SwingConstants.CENTER);

		titelT = new erfassLabel(f.getTitel(),  SwingConstants.CENTER);
		jahrT = new erfassLabel(Integer.toString(f.getJahr()),  SwingConstants.CENTER);
		genreT = new erfassLabel(f.getGenre(),  SwingConstants.CENTER);
		beschreibungT = new erfassLabel(f.getBeschreibung(),  SwingConstants.CENTER);
		


		gl = new GridLayout(7, 2);
		fl = new FlowLayout();

		angaben.setLayout(gl);
		buttons.setLayout(fl);

		abbrechen = new buttons("Abbrechen");
		ausleihen = new buttons("Ausleihen");

		abbrechen.addActionListener(a);
		ausleihen.addActionListener(a);


		if (media != null) {


			id = new erfassLabel(Integer.toString(media.getId()), SwingConstants.CENTER);

			if (media.isLagernd()) {
				lager = new erfassLabel("Ja", SwingConstants.CENTER);
			}
			else {
				lager = new erfassLabel("Nein", SwingConstants.CENTER);
			}
			if (media.getRückgabedatum() != null) {
				verfügbarkeit = new erfassLabel (media.getRückgabedatum().toString(),SwingConstants.CENTER);
			}
			else {
				verfügbarkeit = new erfassLabel("Sofort", SwingConstants.CENTER);

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
					kG = new erfassFrame("Zu wenig Guthaben");

					kG.setVisible(true);
					kG.setSize(300, 150);
					kG.setLocationRelativeTo(null);
					kG.add(new erfassLabel("Zu wenig Guthaben!"), BorderLayout.CENTER);
					kG.add(ok2, BorderLayout.SOUTH);
				}



			}

			if (e.getSource() == ok2) {
				kG.dispose();
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
