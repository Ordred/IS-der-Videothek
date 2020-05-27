package gui;

import java.awt.Color;

import javax.swing.JButton;

public class hmButtons extends JButton {

	public hmButtons(String titel) {

		setText(titel);
		setOpaque(true);
		setBackground(Color.cyan);
		setForeground(Color.black);
		setRolloverEnabled(true);
	}

}
