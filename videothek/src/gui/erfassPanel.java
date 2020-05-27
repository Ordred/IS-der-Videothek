package gui;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.tools.javac.util.LayoutCharacters;

public class erfassPanel extends JPanel {
	
	public erfassPanel (LayoutManager l) {
		
		setLayout(l);
		setBackground(Color.black);
		setForeground(Color.white);
		
	}
	
	public erfassPanel() {

		setBackground(Color.black);
		setForeground(Color.white);
	}

}
