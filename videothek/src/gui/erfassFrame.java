package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class erfassFrame extends JFrame {
	
	public erfassFrame (String titel) {
		
		setBackground(Color.black);
		setForeground(Color.black);
		
		erfassPanel ef = new erfassPanel();
		
		Border padding = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		
		ef.setBorder(padding);
		
		add(ef);
		
	}

}