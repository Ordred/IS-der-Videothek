package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

public class suchLabel extends JLabel {

	
	public suchLabel( String titel, int position) {
		setText(titel);
		setHorizontalAlignment(position);
		
		Font f = new Font("Arial",2,30);
		
		
		
		setOpaque(true);
		setBackground(Color.black);
		setForeground(Color.white);
		setFont(f);
		
		
	}
}
