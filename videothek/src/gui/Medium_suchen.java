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

import controller.UC_Film_suchen;
import controller.UC_Medium_ausleihen;
import controller.UC_Medium_suchen;
import gui_elemente.Buttons;
import gui_elemente.ErfassLabel;
import gui_elemente.ErfassPanel;
import gui_elemente.SuchButton;
import gui_elemente.SuchFrame;
import gui_elemente.SuchLabel;
import model.Film;
import model.Filmliste;
import model.Kundenliste;
import model.Medienliste;
import model.Medium;

public class Medium_suchen extends SuchFrame {

	private ArrayList<Medium> suchergebnisse;
	private ArrayList<SuchButton> suchergebnisseB;
	private ArrayList<SuchLabel> suchergebnisseMedium;
	private ArrayList<SuchLabel> suchergebnisseTitel;	
	private ArrayList<SuchLabel> suchergebnisseGenre;
	private ArrayList<SuchLabel> suchergebnisseJahr;
	private ErfassPanel suchergebnisseP;
	private JScrollPane sucheScroll;
	private GridLayout sucheGL;

	private JLabel [] titelleiste;

	private JDialog suche2;

	private ActionHandler a;

	private Film_anzeigen fa;

	private JDialog nichtgefunden;
	private ErfassLabel nichtgefundenL;
	private Buttons ok;
	private ErfassPanel ngfPanel;

	private String [] kriterien = {"ID", "Medium", "Titel", "Jahr", "Genre", "Beschreibung"};

	private UC_Medium_suchen ucms;


	private JComboBox<String> auswahl = new JComboBox<String>(kriterien);
	private JLabel auswahlL;

	private JTextField suchfeld;
	private JLabel suchbegriffe;

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

	private Kundenliste kl;
	private Medienliste ml;
	private Filmliste fl;
	
	private JDialog zahl;
	private Buttons ok2;


	public Medium_suchen (UC_Medium_suchen ucms, Filmliste fl, Kundenliste kl, Medienliste ml) {

		super("Medium suchen");
		gl = new GridLayout(3, 1);
		super.setLayout(gl);

		suche2 = new JDialog();


		setLocationRelativeTo(null);

		this.kl = kl;
		this.ml = ml;
		this.fl =fl;
		
		ok2 = new Buttons("Ok");


		suchergebnisse = new ArrayList<Medium>();
		suchergebnisseB = new ArrayList<SuchButton>();
		suchergebnisseMedium = new ArrayList<SuchLabel>();
		suchergebnisseTitel = new ArrayList<SuchLabel>();
		suchergebnisseGenre = new ArrayList<SuchLabel>();
		suchergebnisseJahr = new ArrayList<SuchLabel>();
		titelleiste = new JLabel[5];
		titelleiste[0] = new JLabel("ID", SwingConstants.CENTER);
		titelleiste[1] = new JLabel("Medium", SwingConstants.CENTER);
		titelleiste[2] = new JLabel("Titel", SwingConstants.CENTER);
		titelleiste[3] = new JLabel("Genre", SwingConstants.CENTER);
		titelleiste[4] = new JLabel("Jahr", SwingConstants.CENTER);
		suchergebnisseP = new ErfassPanel();
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
			titelleiste[i].setFont(new Font("Arial", 1, 30));
			titelleiste[i].setBackground(Color.gray);
			titelleiste[i].setForeground(Color.white);

		}



		sucheScroll.setPreferredSize(new Dimension(300, 300));


		a = new ActionHandler();
		
		ok2.addActionListener(a);

		this.ucms = ucms;

		auswahl.addActionListener(a);

		auswahlL = new JLabel("Auswahl");

		auswahlL.setForeground(Color.white);

		menu = new ErfassPanel();
		suche = new ErfassPanel();
		buttons = new ErfassPanel();

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

		suchen.setBorder(new EmptyBorder(5,5,5,5));

		add(menu, BorderLayout.NORTH);
		add(suche, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);


		nichtgefunden = new JDialog();
		nichtgefundenL = new ErfassLabel("Es konnte kein Medium mit diesen Angaben gefunden werden", SwingConstants.CENTER);
		nichtgFL = new FlowLayout();
		ok = new Buttons ("Ok");
		ngfPanel = new ErfassPanel();
		ngfPanel.setLayout(nichtgFL);
		ngfPanel.add(ok, BorderLayout.CENTER);
		ok.addActionListener(a);
		nichtgefunden.setTitle("Medium nicht gefunden");
		nichtgefunden.add(nichtgefundenL, BorderLayout.CENTER);
		nichtgefunden.add(ngfPanel, BorderLayout.SOUTH);

		nichtgefunden.setSize(400, 150);
		nichtgefunden.setVisible(false);
		nichtgefunden.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

	}



	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == ok2) {
				zahl.dispose();
			}

			for (int i = 0; i < suchergebnisseB.size(); i++) {

				if (e.getSource() == suchergebnisseB.get(i)) {
					fa = new Film_anzeigen(suchergebnisse.get(i).getFilm(),null, fl, kl,ml, false, suchergebnisse.get(i));
					fa.setSize(600, 500);
					fa.setLocationRelativeTo(null);
					fa.setVisible(true);
					fa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}


			if (e.getSource() == suchen) {
				System.out.println("Suchen");

				try {

					if (auswahl.getSelectedItem() == "Titel") {
						suchergebnisse = ucms.titel(suchfeld.getText());
						for (int i = 0; i < suchergebnisse.size(); i++) {
							sucheGL = new GridLayout(suchergebnisse.size()+1, 5);


							suchergebnisseB.add(new SuchButton(suchergebnisse.get(i).getId()));
							suchergebnisseMedium.add(new SuchLabel(suchergebnisse.get(i).getMedium(), SwingConstants.CENTER));
							suchergebnisseTitel.add(new SuchLabel(suchergebnisse.get(i).getFilm().getTitel(), SwingConstants.CENTER));
							suchergebnisseGenre.add(new SuchLabel(suchergebnisse.get(i).getFilm().getGenre(), SwingConstants.CENTER));
							suchergebnisseJahr.add(new SuchLabel(Integer.toString(suchergebnisse.get(i).getFilm().getJahr()), SwingConstants.CENTER));

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


							suchergebnisseB.add(new SuchButton(suchergebnisse.get(i).getId()));
							suchergebnisseMedium.add(new SuchLabel(suchergebnisse.get(i).getMedium(), SwingConstants.CENTER));
							suchergebnisseTitel.add(new SuchLabel(suchergebnisse.get(i).getFilm().getTitel(), SwingConstants.CENTER));
							suchergebnisseGenre.add(new SuchLabel(suchergebnisse.get(i).getFilm().getGenre(), SwingConstants.CENTER));
							suchergebnisseJahr.add(new SuchLabel(Integer.toString(suchergebnisse.get(i).getFilm().getJahr()), SwingConstants.CENTER));

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


							suchergebnisseB.add(new SuchButton(suchergebnisse.get(i).getId()));
							suchergebnisseMedium.add(new SuchLabel(suchergebnisse.get(i).getMedium(), SwingConstants.CENTER));
							suchergebnisseTitel.add(new SuchLabel(suchergebnisse.get(i).getFilm().getTitel(), SwingConstants.CENTER));
							suchergebnisseGenre.add(new SuchLabel(suchergebnisse.get(i).getFilm().getGenre(), SwingConstants.CENTER));
							suchergebnisseJahr.add(new SuchLabel(Integer.toString(suchergebnisse.get(i).getFilm().getJahr()), SwingConstants.CENTER));

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


							suchergebnisseB.add(new SuchButton(suchergebnisse.get(i).getId()));
							suchergebnisseMedium.add(new SuchLabel(suchergebnisse.get(i).getMedium(), SwingConstants.CENTER));
							suchergebnisseTitel.add(new SuchLabel(suchergebnisse.get(i).getFilm().getTitel(), SwingConstants.CENTER));
							suchergebnisseGenre.add(new SuchLabel(suchergebnisse.get(i).getFilm().getGenre(), SwingConstants.CENTER));
							suchergebnisseJahr.add(new SuchLabel(Integer.toString(suchergebnisse.get(i).getFilm().getJahr()), SwingConstants.CENTER));

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


							suchergebnisseB.add(new SuchButton(suchergebnisse.get(i).getId()));
							suchergebnisseMedium.add(new SuchLabel(suchergebnisse.get(i).getMedium(), SwingConstants.CENTER));
							suchergebnisseTitel.add(new SuchLabel(suchergebnisse.get(i).getFilm().getTitel(), SwingConstants.CENTER));
							suchergebnisseGenre.add(new SuchLabel(suchergebnisse.get(i).getFilm().getGenre(), SwingConstants.CENTER));
							suchergebnisseJahr.add(new SuchLabel(Integer.toString(suchergebnisse.get(i).getFilm().getJahr()), SwingConstants.CENTER));

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
						suche2.setSize(1600,500);
						suche2.setLocationRelativeTo(null);
						suche2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						dispose();
					}

					else {
						nichtgefunden.setLocationRelativeTo(null);
						nichtgefunden.setVisible(true);
					}

				} catch (NumberFormatException exception) {
					
					zahl = new JDialog();
					zahl.setTitle("Bitte Zahl eingeben");
					zahl.setVisible(true);
					zahl.add(new ErfassLabel("Bitte Zahl eingeben!", SwingConstants.CENTER), BorderLayout.CENTER);
					zahl.add(ok2, BorderLayout.SOUTH);
					zahl.setSize(300, 150);
					zahl.setModal(true);
					zahl.setLocationRelativeTo(null);
					zahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}

			}
			if (e.getSource() == abbrechen) {
				dispose();
			}

			if (e.getSource() == ok) {
				nichtgefunden.setVisible(false);
			}
		}
	}
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


