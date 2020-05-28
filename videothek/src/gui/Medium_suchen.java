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
import javax.swing.ImageIcon;

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

import controller.UC_Film_suchen;
import controller.UC_Medium_ausleihen;
import controller.UC_Medium_suchen;
import model.Film;
import model.Filmliste;
import model.Kundenliste;
import model.Medienliste;
import model.Medium;

public class Medium_suchen extends suchFrame {

	private ArrayList<Medium> suchergebnisse;
	private ArrayList<suchButton> suchergebnisseB;
	private ArrayList<suchLabel> suchergebnisseMedium;
	private ArrayList<suchLabel> suchergebnisseTitel;	
	private ArrayList<suchLabel> suchergebnisseGenre;
	private ArrayList<suchLabel> suchergebnisseJahr;
	private JPanel suchergebnisseP;
	private JScrollPane sucheScroll;
	private GridLayout sucheGL;

	private JLabel [] titelleiste;

	private JDialog suche2;

	private ActionHandler a;

	private Film_anzeigen fa;

	private JDialog nichtgefunden;
	private JLabel nichtgefundenL;
	private buttons ok;
	private JPanel ngfPanel;

	private String [] kriterien = {"ID", "Medium", "Titel", "Jahr", "Genre", "Beschreibung"};

	private UC_Medium_suchen ucms;


	private JComboBox<String> auswahl = new JComboBox<String>(kriterien);
	private JLabel auswahlL;

	private JTextField suchfeld;
	private JLabel suchbegriffe;

	private buttons suchen;
	private buttons abbrechen;

	private FlowLayout flow1;
	private FlowLayout flow2;
	private FlowLayout flow3;
	private FlowLayout nichtgFL;

	private GridLayout gl;

	private erfassPanel menu;
	private erfassPanel suche;
	private erfassPanel buttons;
	
	private Kundenliste kl;
	private Medienliste ml;

	public Medium_suchen (UC_Medium_suchen ucms, Kundenliste kl, Medienliste ml) {

		super("Medium suchen");
		gl = new GridLayout(3, 1);
		super.setLayout(gl);

		suche2 = new JDialog();

		
		setLocationRelativeTo(null);
		
		this.kl = kl;
		this.ml = ml;

		suchergebnisse = new ArrayList<Medium>();
		suchergebnisseB = new ArrayList<suchButton>();
		suchergebnisseMedium = new ArrayList<suchLabel>();
		suchergebnisseTitel = new ArrayList<suchLabel>();
		suchergebnisseGenre = new ArrayList<suchLabel>();
		suchergebnisseJahr = new ArrayList<suchLabel>();
		titelleiste = new JLabel[5];
		titelleiste[0] = new JLabel("ID", SwingConstants.CENTER);
		titelleiste[1] = new JLabel("Medium", SwingConstants.CENTER);
		titelleiste[2] = new JLabel("Titel", SwingConstants.CENTER);
		titelleiste[3] = new JLabel("Genre", SwingConstants.CENTER);
		titelleiste[4] = new JLabel("Jahr", SwingConstants.CENTER);
		suchergebnisseP = new JPanel();
		sucheGL = new GridLayout(20, 3);


		suchergebnisseP.setLayout(sucheGL);
		sucheScroll = new JScrollPane(suchergebnisseP,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		suchergebnisseP.add(titelleiste[0]);
		suchergebnisseP.add(titelleiste[1]);
		suchergebnisseP.add(titelleiste[2]);
		suchergebnisseP.add(titelleiste[3]);
		suchergebnisseP.add(titelleiste[4]);

		for (int i = 0; i < titelleiste.length; i++) {


			titelleiste[i].setOpaque(true);
			titelleiste[i].setFont(new Font("Arial", 3, 40));
			titelleiste[i].setBackground(Color.gray);
			titelleiste[i].setForeground(Color.white);

		}
		
		

		sucheScroll.setPreferredSize(new Dimension(300, 300));


		a = new ActionHandler();

		this.ucms = ucms;

		auswahl.addActionListener(a);

		auswahlL = new JLabel("Auswahl");
		
		auswahlL.setForeground(Color.white);

		menu = new erfassPanel();
		suche = new erfassPanel();
		buttons = new erfassPanel();

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
		abbrechen = new buttons("Abbrechen");

		suchen.addActionListener(a);
		abbrechen.addActionListener(a);

		suchfeld = new JTextField("Suchbegriff eingeben");
		suchbegriffe = new JLabel("Suchbegriffe");
		
		suchbegriffe.setForeground(Color.white);

		suche.add(suchbegriffe, BorderLayout.WEST);
		suche.add(suchfeld, BorderLayout.CENTER);

		buttons.add(abbrechen, BorderLayout.WEST);
		buttons.add(suchen, BorderLayout.EAST);

		menu.add(auswahlL);
		menu.add(auswahl);



		add(menu, BorderLayout.NORTH);
		add(suche, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);


		nichtgefunden = new JDialog();
		nichtgefundenL = new erfassLabel("Es konnte kein Film mit diesen Angaben gefunden werden");
		nichtgFL = new FlowLayout();
		ok = new buttons ("Ok");
		ngfPanel = new erfassPanel();
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

			for (int i = 0; i < suchergebnisseB.size(); i++) {
				if (e.getSource() == suchergebnisseB.get(i)) {
					fa = new Film_anzeigen(suchergebnisse.get(i).getFilm(),null,kl,ml, false, suchergebnisse.get(i));
					
					fa.setVisible(true);
					fa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}


			if (e.getSource() == suchen) {
				System.out.println("Suchen");

				if (auswahl.getSelectedItem() == "Titel") {
					suchergebnisse = ucms.titel(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 5);


						suchergebnisseB.add(new suchButton(Integer.toString(suchergebnisse.get(i).getId())));
						suchergebnisseMedium.add(new suchLabel(suchergebnisse.get(i).getMedium(), SwingConstants.CENTER));
						suchergebnisseTitel.add(new suchLabel(suchergebnisse.get(i).getFilm().getTitel(), SwingConstants.CENTER));
						suchergebnisseGenre.add(new suchLabel(suchergebnisse.get(i).getFilm().getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new suchLabel(Integer.toString(suchergebnisse.get(i).getFilm().getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseMedium.get(i));
						suchergebnisseP.add(suchergebnisseTitel.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseMedium.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseTitel.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseGenre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseJahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseB.get(i).getText());
					}
				}

				if (auswahl.getSelectedItem() == "ID") {
					suchergebnisse = ucms.id(Integer.parseInt(suchfeld.getText()));
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 5);


						suchergebnisseB.add(new suchButton(Integer.toString(suchergebnisse.get(i).getId())));
						suchergebnisseMedium.add(new suchLabel(suchergebnisse.get(i).getMedium(), SwingConstants.CENTER));
						suchergebnisseTitel.add(new suchLabel(suchergebnisse.get(i).getFilm().getTitel(), SwingConstants.CENTER));
						suchergebnisseGenre.add(new suchLabel(suchergebnisse.get(i).getFilm().getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new suchLabel(Integer.toString(suchergebnisse.get(i).getFilm().getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseMedium.get(i));
						suchergebnisseP.add(suchergebnisseTitel.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseMedium.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseTitel.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseGenre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseJahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseB.get(i).getText());
					}
				}

				if (auswahl.getSelectedItem() == "Medium") {
					suchergebnisse = ucms.medium(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 5);


						suchergebnisseB.add(new suchButton(Integer.toString(suchergebnisse.get(i).getId())));
						suchergebnisseMedium.add(new suchLabel(suchergebnisse.get(i).getMedium(), SwingConstants.CENTER));
						suchergebnisseTitel.add(new suchLabel(suchergebnisse.get(i).getFilm().getTitel(), SwingConstants.CENTER));
						suchergebnisseGenre.add(new suchLabel(suchergebnisse.get(i).getFilm().getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new suchLabel(Integer.toString(suchergebnisse.get(i).getFilm().getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseMedium.get(i));
						suchergebnisseP.add(suchergebnisseTitel.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseMedium.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseTitel.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
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
					suchergebnisse = ucms.jahr(Integer.parseInt(suchfeld.getText()));
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 5);


						suchergebnisseB.add(new suchButton(Integer.toString(suchergebnisse.get(i).getId())));
						suchergebnisseMedium.add(new suchLabel(suchergebnisse.get(i).getMedium(), SwingConstants.CENTER));
						suchergebnisseTitel.add(new suchLabel(suchergebnisse.get(i).getFilm().getTitel(), SwingConstants.CENTER));
						suchergebnisseGenre.add(new suchLabel(suchergebnisse.get(i).getFilm().getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new suchLabel(Integer.toString(suchergebnisse.get(i).getFilm().getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseMedium.get(i));
						suchergebnisseP.add(suchergebnisseTitel.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseMedium.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseTitel.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
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
					suchergebnisse = ucms.genre(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 5);


						suchergebnisseB.add(new suchButton(Integer.toString(suchergebnisse.get(i).getId())));
						suchergebnisseMedium.add(new suchLabel(suchergebnisse.get(i).getMedium(), SwingConstants.CENTER));
						suchergebnisseTitel.add(new suchLabel(suchergebnisse.get(i).getFilm().getTitel(), SwingConstants.CENTER));
						suchergebnisseGenre.add(new suchLabel(suchergebnisse.get(i).getFilm().getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new suchLabel(Integer.toString(suchergebnisse.get(i).getFilm().getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseMedium.get(i));
						suchergebnisseP.add(suchergebnisseTitel.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseMedium.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseTitel.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
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
					suche2.setSize(800,800);
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


