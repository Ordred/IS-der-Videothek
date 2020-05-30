package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import controller.UC_Film_bearbeiten;
import controller.UC_Film_suchen;
import controller.UC_Kunde_suchen;
import controller.UC_Medium_ausleihen;
import controller.UC_Medium_erfassen;
import model.Film;
import model.Filmliste;
import model.Kunde;
import model.Kundenliste;
import model.Medienliste;

public class Film_suchen extends suchFrame {

	private ArrayList<Film> suchergebnisse;
	private ArrayList<suchButton> suchergebnisseB;
	private ArrayList<suchLabel> suchergebnisseGenre;
	private ArrayList<suchLabel> suchergebnisseJahr;
	private JPanel suchergebnisseP;
	private JScrollPane sucheScroll;
	private GridLayout sucheGL;
	private boolean medium;

	private JLabel [] titelleiste;

	private JDialog suche2;

	private ActionHandler a;

	private Film_anzeigen fa;

	private JDialog nichtgefunden;
	private JLabel nichtgefundenL;
	private buttons ok;
	private erfassPanel ngfPanel;

	private String [] kriterien = {"Titel", "Jahr", "Genre", "Beschreibung"};

	private UC_Film_suchen ucfs;
	private UC_Medium_erfassen ucme;

	private JComboBox<String> auswahl = new JComboBox<String>(kriterien);
	private JLabel auswahlL;

	private JTextField suchfeld;
	private JLabel suchbegriffe;

	private JButton suchen;
	private buttons abbrechen;

	private FlowLayout flow1;
	private FlowLayout flow2;
	private FlowLayout flow3;
	private FlowLayout nichtgFL;

	private GridLayout gl;

	private JPanel menu;
	private JPanel suche;
	private JPanel buttons;

	private boolean admin;
	private Kunde k;
	private Kundenliste kl;
	private Medienliste ml;
	private UC_Film_bearbeiten ucfb;

	public Film_suchen (UC_Film_bearbeiten ucfb, UC_Film_suchen ucsf, boolean medium, Kunde k, boolean admin, UC_Medium_erfassen ucme, Kundenliste kl, Medienliste ml) {

		super("Film suchen");
		gl = new GridLayout(3, 1);
		super.setLayout(gl);

		setLocationRelativeTo(null);

		this.medium = medium;
		this.ucme = ucme;
		this.ucfb = ucfb;
		this.k = k;
		this.admin = admin;
		this.kl = kl;
		this.ml = ml;

		suche2 = new JDialog();


		suchergebnisse = new ArrayList<Film>();
		suchergebnisseB = new ArrayList<suchButton>();
		suchergebnisseGenre = new ArrayList<suchLabel>();
		suchergebnisseJahr = new ArrayList<suchLabel>();
		titelleiste = new JLabel[3];
		titelleiste[0] = new erfassLabel("Titel", SwingConstants.CENTER);
		titelleiste[1] = new erfassLabel("Genre", SwingConstants.CENTER);
		titelleiste[2] = new erfassLabel("Jahr", SwingConstants.CENTER);
		suchergebnisseP = new JPanel();
		sucheGL = new GridLayout(20, 3);

		suchergebnisseP.setBackground(Color.black);
		suchergebnisseP.setForeground(Color.white);

		suchergebnisseP.setLayout(sucheGL);
		sucheScroll = new JScrollPane(suchergebnisseP,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		suchergebnisseP.add(titelleiste[0]);
		suchergebnisseP.add(titelleiste[1]);
		suchergebnisseP.add(titelleiste[2]);

		for (int i = 0; i < titelleiste.length; i++) {


			titelleiste[i].setOpaque(true);
			titelleiste[i].setFont(new Font("Arial", 3, 20));
			titelleiste[i].setBackground(Color.gray);
			titelleiste[i].setForeground(Color.white);

		}



		sucheScroll.setPreferredSize(new Dimension(300, 300));


		a = new ActionHandler();

		this.ucfs = ucsf;

		auswahl.addActionListener(a);

		auswahlL = new erfassLabel("Auswahl", SwingConstants.LEFT);

		menu = new erfassPanel(null);
		suche = new erfassPanel(null);
		buttons = new erfassPanel(null);

		flow1 = new FlowLayout();
		flow2 = new FlowLayout();
		flow3 = new FlowLayout();

		suche.setLayout(flow1);
		buttons.setLayout(flow2);
		menu.setLayout(flow3);


		ImageIcon sucheIc = new ImageIcon("hiclipart.com.png");


		Image img = sucheIc.getImage() ;  
		Image newimg = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;  
		sucheIc = new ImageIcon( newimg );

		suchen = new buttons(sucheIc);



		suchen.setSize(20, 20);

		abbrechen = new buttons("Abbrechen");

		suchen.addActionListener(a);
		abbrechen.addActionListener(a);

		suchfeld = new JTextField("Suchbegriff eingeben");
		suchbegriffe = new erfassLabel("Suchbegriffe", SwingConstants.LEFT);

		suche.add(suchbegriffe, BorderLayout.WEST);
		suche.add(suchfeld, BorderLayout.CENTER);

		buttons.add(abbrechen, BorderLayout.WEST);
		buttons.add(suchen, BorderLayout.EAST);

		menu.add(auswahlL);
		menu.add(auswahl);

		suchergebnisseP.setBackground(Color.black);

		add(menu, BorderLayout.NORTH);
		add(suche, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);


		nichtgefunden = new JDialog();
		nichtgefunden.setBackground(Color.black);
		nichtgefundenL = new erfassLabel("Es konnte kein Film mit diesen Angaben gefunden werden", SwingConstants.CENTER);
		nichtgFL = new FlowLayout();
		ok = new buttons ("Ok");
		ngfPanel = new erfassPanel(null);
		ngfPanel.setLayout(nichtgFL);
		ngfPanel.add(ok, BorderLayout.CENTER);
		ok.addActionListener(a);
		nichtgefunden.setTitle("Film nicht gefunden");
		nichtgefunden.add(nichtgefundenL, BorderLayout.CENTER);
		nichtgefunden.add(ngfPanel, BorderLayout.SOUTH);

		nichtgefunden.pack();
		nichtgefunden.setVisible(false);
		nichtgefunden.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

	}


	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (!medium) {

				for (int i = 0; i < suchergebnisseB.size(); i++) {
					if (e.getSource() == suchergebnisseB.get(i)) {
						fa = new Film_anzeigen(suchergebnisse.get(i), k, kl, ml, medium, null);
						fa.setVisible(true);
						fa.setSize(600, 400);
						fa.setLocationRelativeTo(null);
						fa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}
			}

			else {
				for (int i = 0; i < suchergebnisseB.size(); i++) {
					if (e.getSource() == suchergebnisseB.get(i)) {
						
						if (ucme != null) {
						ucme.setFilm2(suchergebnisse.get(i));
						}
						else {
							ucfb.setFilm(suchergebnisse.get(i));
						}
						suche2.dispose();
						dispose();
					}
				}
			}


			if (e.getSource() == suchen) {
				System.out.println("Suchen");

				if (auswahl.getSelectedItem() == "Titel") {
					suchergebnisse = ucfs.titel(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 3);

						suchergebnisseB.add(new suchButton(suchergebnisse.get(i).getTitel()));
						suchergebnisseGenre.add(new suchLabel(suchergebnisse.get(i).getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new suchLabel(Integer.toString(suchergebnisse.get(i).getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseGenre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseJahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseB.get(i).getText());
					}
				}


				if (auswahl.getSelectedItem() == "Jahr") {
					suchergebnisse = ucfs.jahr(Integer.parseInt(suchfeld.getText()));
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(3, suchergebnisse.size()+1);

						suchergebnisseB.add(new suchButton(suchergebnisse.get(i).getTitel()));
						suchergebnisseGenre.add(new suchLabel(suchergebnisse.get(i).getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new suchLabel(Integer.toString(suchergebnisse.get(i).getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseGenre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseJahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseB.get(i).getText());


					}
				}

				if (auswahl.getSelectedItem() == "Genre") {
					suchergebnisse = ucfs.genre(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(3, suchergebnisse.size()+1);

						suchergebnisseB.add(new suchButton(suchergebnisse.get(i).getTitel()));
						suchergebnisseGenre.add(new suchLabel(suchergebnisse.get(i).getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new suchLabel(Integer.toString(suchergebnisse.get(i).getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseGenre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseJahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseB.get(i).getText());
					}
				}

				if (auswahl.getSelectedItem() == "Beschreibung") {
					suchergebnisse = ucfs.beschreibung(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {

						sucheGL = new GridLayout(3, suchergebnisse.size()+1);

						suchergebnisseB.add(new suchButton(suchergebnisse.get(i).getTitel()));
						suchergebnisseGenre.add(new suchLabel(suchergebnisse.get(i).getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new suchLabel(Integer.toString(suchergebnisse.get(i).getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseGenre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseJahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseB.get(i).getText());

					}
				}

				if (suchergebnisse.size() > 0) {

					suche2 = new JDialog();
					suche2.setTitle("Suchergebnisse");
					suche2.add(sucheScroll);
					suche2.setVisible(true);
					suche2.setSize(800,600);
					suche2.setLocationRelativeTo(null);
					suche2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					dispose();

				}

				else {
					nichtgefunden.setVisible(true);
				}
			}

			if (e.getSource() == abbrechen) {
				dispose();
			}

			if (e.getSource() == ok) {
				nichtgefunden.setVisible(false);
			}


			/*
					System.out.println("Titel Suche");
					try {
						fa = new Film_anzeigen(ucfs.titel(suchfeld.getText()));
						fa.setVisible(true);
						fa.setSize(400, 400);
						fa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					} catch (NullPointerException exception) {

						nichtgefunden.setVisible(true);
					}

				}

				if (auswahl.getSelectedItem() == "Jahr") {
					suchergebnisse = ucfs.jahr(Integer.parseInt(suchfeld.getText()));
					for (int i = 0; i < suchergebnisse.size(); i++) {

						suchergebnisseL.add(new buttons(suchergebnisse.get(i).getJahr()+"\t"+
								suchergebnisse.get(i).getGenre()+"\t"+suchergebnisse.get(i).getJahr()));

					}

					if (auswahl.getSelectedItem() == "Genre") {
						suchergebnisse = ucfs.genre(suchfeld.getText());
						for (int i = 0; i < suchergebnisse.size(); i++) {

							suchergebnisseL.add(new buttons(suchergebnisse.get(i).getTitel()+"\t"+
									suchergebnisse.get(i).getGenre()+"\t"+suchergebnisse.get(i).getJahr()));

						}

						if (auswahl.getSelectedItem() == "Beschreibung") {
							suchergebnisse = ucfs.beschreibung(suchfeld.getText());
							for (int i = 0; i < suchergebnisse.size(); i++) {

								suchergebnisseL.add(new buttons(suchergebnisse.get(i).getTitel()+"\t"+
										suchergebnisse.get(i).getGenre()+"\t"+suchergebnisse.get(i).getJahr()));

							}		

						}
			 */



		}
	}
}


