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
import javax.swing.border.EmptyBorder;

import controller.UC_Guthaben_aufladen;
import controller.UC_Kunde_suchen;
import controller.UC_Medium_ausleihen;
import gui_elemente.Buttons;
import gui_elemente.ErfassLabel;
import gui_elemente.ErfassPanel;
import gui_elemente.SuchButton;
import gui_elemente.SuchFrame;
import gui_elemente.SuchLabel;
import model.Geschäftseinnahmen;
import model.Kunde;
import model.Kundenliste;


public class Kunde_suchen extends SuchFrame {

	private boolean admin;

	private Kunde k;


	private ArrayList<Kunde> suchergebnisse;
	private ArrayList<SuchButton> suchergebnisseName;
	private ArrayList<SuchLabel> suchergebnisseVorname;
	private ArrayList<SuchLabel> suchergebnisseGeburtsdatum;
	private ErfassPanel suchergebnisseP;
	private JScrollPane sucheScroll;
	private GridLayout sucheGL;

	private JLabel [] titelleiste;

	private JDialog suche2;

	private ActionHandler a;

	private Kunde_anzeigen ka;

	private Kundenliste kl;

	private JDialog nichtgefunden;
	private ErfassLabel nichtgefundenL;
	private Buttons ok;
	private ErfassPanel ngfPanel;

	private String [] kriterien = {"Name", "Vorname", "Geburtsdatum", "Ort", "Adresse", "Telefon", "Lieblingsgenre"};

	private UC_Kunde_suchen ucks;


	private JComboBox<String> auswahl = new JComboBox<String>(kriterien);
	private JLabel auswahlL;

	private JTextField suchfeld;
	private ErfassLabel suchbegriffe;

	private Buttons suchen;
	private Buttons abbrechen;

	private FlowLayout flow1;
	private FlowLayout flow2;
	private FlowLayout flow3;
	private FlowLayout nichtgFL;

	private GridLayout gl;

	private ErfassPanel menu;
	private ErfassPanel suche;
	private ErfassPanel buttons;
	
	private Geschäftseinnahmen ge;

	public Kunde_suchen (Geschäftseinnahmen ge, UC_Kunde_suchen ucks, Kundenliste kl, boolean admin) {

		super("Kunde suchen");
		gl = new GridLayout(3, 1);
		super.setLayout(gl);
		
		this.ge = ge;


	
		suche2 = new JDialog();

		this.ucks = ucks;
		this.kl = kl;
		this.admin = admin;



		suchergebnisse = new ArrayList<Kunde>();
		suchergebnisseName = new ArrayList<SuchButton>();
		suchergebnisseVorname = new ArrayList<SuchLabel>();
		suchergebnisseGeburtsdatum = new ArrayList<SuchLabel>();
		titelleiste = new JLabel[3];
		titelleiste[0] = new JLabel("Name", SwingConstants.CENTER);
		titelleiste[1] = new JLabel("Vorname", SwingConstants.CENTER);
		titelleiste[2] = new JLabel("Geburtsdatum", SwingConstants.CENTER);
		suchergebnisseP = new ErfassPanel();
		sucheGL = new GridLayout(20, 3);


		suchergebnisseP.setLayout(sucheGL);
		sucheScroll = new JScrollPane(suchergebnisseP,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		suchergebnisseP.add(titelleiste[0]);
		suchergebnisseP.add(titelleiste[1]);
		suchergebnisseP.add(titelleiste[2]);

		

		for (int i = 0; i < titelleiste.length; i++) {


			titelleiste[i].setOpaque(true);
			titelleiste[i].setFont(new Font("Arial", 3, 40));
			titelleiste[i].setBackground(Color.gray);
			titelleiste[i].setForeground(Color.white);

		}

		sucheScroll.setPreferredSize(new Dimension(300, 300));


		a = new ActionHandler();

		auswahl.addActionListener(a);

		auswahlL = new ErfassLabel("Auswahl");

		menu = new ErfassPanel(null);
		suche = new ErfassPanel(null);
		buttons = new ErfassPanel(null);

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

		suchen = new Buttons(sucheIc);
		abbrechen = new Buttons("Abbrechen");
		
		suchen.setBorder(new EmptyBorder(5,5,5,5));

		suchen.addActionListener(a);
		abbrechen.addActionListener(a);

		suchfeld = new JTextField("Suchbegriff eingeben");
		suchbegriffe = new ErfassLabel("Suchbegriffe", SwingConstants.LEFT);

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
		nichtgefundenL = new ErfassLabel("Es konnte kein Kunde mit diesen Angaben gefunden werden");
		nichtgFL = new FlowLayout();
		ok = new Buttons ("Ok");
		ngfPanel = new ErfassPanel();
		ngfPanel.setLayout(nichtgFL);
		ngfPanel.add(ok, BorderLayout.CENTER);
		ok.addActionListener(a);
		nichtgefunden.setTitle("Kunde nicht gefunden");
		nichtgefunden.add(nichtgefundenL, BorderLayout.CENTER);
		nichtgefunden.add(ngfPanel, BorderLayout.SOUTH);

		nichtgefunden.pack();
		nichtgefunden.setVisible(false);
		nichtgefunden.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

	}



	public Kunde getK() {
		return k;
	}



	public void setK(Kunde k) {
		this.k = k;
	}



	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {



			if (!admin) {

				for (int i = 0; i < suchergebnisseName.size(); i++) {
					if (e.getSource() == suchergebnisseName.get(i)) {
						ka = new Kunde_anzeigen(ge, suchergebnisse.get(i), kl);
						ka.setSize(450, 450);
						ka.setVisible(true);
						ka.setLocationRelativeTo(null);
						ka.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}
			}

			else {
				for (int i = 0; i < suchergebnisseName.size(); i++) {
					if (e.getSource() == suchergebnisseName.get(i)) {
						k = suchergebnisse.get(i);
						System.out.println("Kunde gesetzt");
						suche2.dispose();
						dispose();
					}
				}
			}


			if (e.getSource() == suchen) {
				System.out.println("Suchen");
				try {
				if (auswahl.getSelectedItem() == "Name") {
					suchergebnisse = ucks.name(suchfeld.getText());
					System.out.println(suchergebnisse.get(0).getName());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 3);

						suchergebnisseName.add(new SuchButton(suchergebnisse.get(i).getName()));
						suchergebnisseVorname.add(new SuchLabel(suchergebnisse.get(i).getVorname(), SwingConstants.CENTER));
						suchergebnisseGeburtsdatum.add(new SuchLabel(suchergebnisse.get(i).getGeburtsdatum(), SwingConstants.CENTER));

						suchergebnisseName.get(i).setSize(300, 10);

						suchergebnisseName.get(i).setVisible(true);
						suchergebnisseName.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseName.get(i));
						suchergebnisseP.add(suchergebnisseVorname.get(i));
						suchergebnisseP.add(suchergebnisseGeburtsdatum.get(i));
						suchergebnisseVorname.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseGeburtsdatum.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseName.get(i).getText());
					}
				}
				
				if (auswahl.getSelectedItem() == "Ort") {
					suchergebnisse = ucks.name(suchfeld.getText());
					System.out.println(suchergebnisse.get(0).getName());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 3);

						suchergebnisseName.add(new SuchButton(suchergebnisse.get(i).getName()));
						suchergebnisseVorname.add(new SuchLabel(suchergebnisse.get(i).getVorname(), SwingConstants.CENTER));
						suchergebnisseGeburtsdatum.add(new SuchLabel(suchergebnisse.get(i).getGeburtsdatum(), SwingConstants.CENTER));

						suchergebnisseName.get(i).setSize(300, 10);

						suchergebnisseName.get(i).setVisible(true);
						suchergebnisseName.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseName.get(i));
						suchergebnisseP.add(suchergebnisseVorname.get(i));
						suchergebnisseP.add(suchergebnisseGeburtsdatum.get(i));
						suchergebnisseVorname.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseGeburtsdatum.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseName.get(i).getText());
					}
				}
				
				if (auswahl.getSelectedItem() == "Adresse") {
					suchergebnisse = ucks.name(suchfeld.getText());
					System.out.println(suchergebnisse.get(0).getName());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 3);

						suchergebnisseName.add(new SuchButton(suchergebnisse.get(i).getName()));
						suchergebnisseVorname.add(new SuchLabel(suchergebnisse.get(i).getVorname(), SwingConstants.CENTER));
						suchergebnisseGeburtsdatum.add(new SuchLabel(suchergebnisse.get(i).getGeburtsdatum(), SwingConstants.CENTER));

						suchergebnisseName.get(i).setSize(300, 10);

						suchergebnisseName.get(i).setVisible(true);
						suchergebnisseName.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseName.get(i));
						suchergebnisseP.add(suchergebnisseVorname.get(i));
						suchergebnisseP.add(suchergebnisseGeburtsdatum.get(i));
						suchergebnisseVorname.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseGeburtsdatum.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseName.get(i).getText());
					}
				}
				
				if (auswahl.getSelectedItem() == "Telefon") {
					suchergebnisse = ucks.name(suchfeld.getText());
					System.out.println(suchergebnisse.get(0).getName());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 3);

						suchergebnisseName.add(new SuchButton(suchergebnisse.get(i).getName()));
						suchergebnisseVorname.add(new SuchLabel(suchergebnisse.get(i).getVorname(), SwingConstants.CENTER));
						suchergebnisseGeburtsdatum.add(new SuchLabel(suchergebnisse.get(i).getGeburtsdatum(), SwingConstants.CENTER));

						suchergebnisseName.get(i).setSize(300, 10);

						suchergebnisseName.get(i).setVisible(true);
						suchergebnisseName.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseName.get(i));
						suchergebnisseP.add(suchergebnisseVorname.get(i));
						suchergebnisseP.add(suchergebnisseGeburtsdatum.get(i));
						suchergebnisseVorname.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseGeburtsdatum.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseName.get(i).getText());
					}
				}


				if (auswahl.getSelectedItem() == "Vorname") {
					suchergebnisse = ucks.vorname(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 3);

						suchergebnisseName.add(new SuchButton(suchergebnisse.get(i).getName()));
						suchergebnisseVorname.add(new SuchLabel(suchergebnisse.get(i).getVorname(), SwingConstants.CENTER));
						suchergebnisseGeburtsdatum.add(new SuchLabel(suchergebnisse.get(i).getGeburtsdatum(), SwingConstants.CENTER));

						suchergebnisseName.get(i).setSize(300, 10);

						suchergebnisseName.get(i).setVisible(true);
						suchergebnisseName.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseName.get(i));
						suchergebnisseP.add(suchergebnisseVorname.get(i));
						suchergebnisseP.add(suchergebnisseGeburtsdatum.get(i));
						suchergebnisseVorname.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseGeburtsdatum.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseName.get(i).getText());
					}
				}


				if (auswahl.getSelectedItem() == "Geburtsdatum") {
					suchergebnisse = ucks.geburtsdatum(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 3);

						suchergebnisseName.add(new SuchButton(suchergebnisse.get(i).getName()));
						suchergebnisseVorname.add(new SuchLabel(suchergebnisse.get(i).getVorname(), SwingConstants.CENTER));
						suchergebnisseGeburtsdatum.add(new SuchLabel(suchergebnisse.get(i).getGeburtsdatum(), SwingConstants.CENTER));

						suchergebnisseName.get(i).setSize(300, 10);

						suchergebnisseName.get(i).setVisible(true);
						suchergebnisseName.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseName.get(i));
						suchergebnisseP.add(suchergebnisseVorname.get(i));
						suchergebnisseP.add(suchergebnisseGeburtsdatum.get(i));
						suchergebnisseVorname.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseGeburtsdatum.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseName.get(i).getText());
					}
				}

				if (auswahl.getSelectedItem() == "Lieblingsgenre") {
					suchergebnisse = ucks.lieblingsgenre(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 3);

						suchergebnisseName.add(new SuchButton(suchergebnisse.get(i).getName()));
						suchergebnisseVorname.add(new SuchLabel(suchergebnisse.get(i).getVorname(), SwingConstants.CENTER));
						suchergebnisseGeburtsdatum.add(new SuchLabel(suchergebnisse.get(i).getGeburtsdatum(), SwingConstants.CENTER));

						suchergebnisseName.get(i).setSize(300, 10);

						suchergebnisseName.get(i).setVisible(true);
						suchergebnisseName.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseName.get(i));
						suchergebnisseP.add(suchergebnisseVorname.get(i));
						suchergebnisseP.add(suchergebnisseGeburtsdatum.get(i));
						suchergebnisseVorname.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseGeburtsdatum.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseName.get(i).getText());
					}
				}
				} catch (IndexOutOfBoundsException exception) {
					
				}

				if (suchergebnisse.size() > 0) {

					suche2 = new JDialog();
					suche2.setTitle("Suchergebnisse");
					suche2.add(sucheScroll);
					suche2.setVisible(true);
					suche2.setSize (900, 800);
					suche2.setLocationRelativeTo(null);
					suche2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					dispose();
				}

				else {
					nichtgefunden.setLocationRelativeTo(null);
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
							fa = new Kunde_anzeigen(ucfs.titel(suchfeld.getText()));
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
