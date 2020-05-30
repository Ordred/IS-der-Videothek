package gui_elemente;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.tools.javac.util.LayoutCharacters;

public class ErfassPanel extends JPanel {
	
	public ErfassPanel (LayoutManager l) {
		
		setLayout(l);
		setBackground(Color.black);
		setForeground(Color.white);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		
	}
	
	public ErfassPanel() {

		
		setBackground(Color.black);
		setForeground(Color.white);
		setBorder(new EmptyBorder(20, 20, 20, 20));
	}

}
