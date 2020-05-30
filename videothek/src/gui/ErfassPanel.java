package gui;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.tools.javac.util.LayoutCharacters;

public class ErfassPanel extends JPanel {
	
	public ErfassPanel (LayoutManager l) {
		
		setLayout(l);
		setBackground(Color.black);
		setForeground(Color.white);
		
	}
	
	public ErfassPanel() {

		
		setBackground(Color.black);
		setForeground(Color.white);
	}

}
