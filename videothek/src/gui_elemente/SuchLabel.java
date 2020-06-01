package gui_elemente;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SuchLabel extends JLabel {

	
	public SuchLabel( String titel, int position) {
		setText(titel);
		setHorizontalAlignment(position);
		
		Font f = new Font("Arial",1,18);
		
		
		
		setOpaque(true);
		setBackground(Color.black);
		setForeground(Color.white);
		setFont(f);
		
		
	}
}
